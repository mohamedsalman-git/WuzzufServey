//import com.sparkTutorial.rdd.commons.Utils;

import javafx.scene.chart.PieChart;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;

import javax.swing.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.functions.col;


public class WuzzufSurvey {
    public static void main(String[] args) throws Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession session = SparkSession.builder().appName("WuzzufSurvey").master("local[1]").getOrCreate();

        DataFrameReader dataFrameReader = session.read();

        Dataset<Row> responses = dataFrameReader.option("header", "true").csv("Wuzzuf_Jobs.csv");
        RelationalGroupedDataset groupedDataset;

        System.out.println("\n=== Print 20 records of responses table ===:\n");
        responses.show(20);

        System.out.println("\n=== Print out schema (structure and summary) ===:\n");
        responses.printSchema();

        System.out.println("\n=== Print out data cleaning results ===:\n");
        // Data cleaning
        int countBefore= (int) responses.count();
        // removing any duplicates
        responses=responses.dropDuplicates();

        int countAfter= (int) responses.count();

        System.out.print("\nBefore removing duplicates number of rows:");
        System.out.println(countBefore);
        System.out.print(countBefore-countAfter);
        System.out.print(" duplicates have been removed the new size is:");
        System.out.println(countAfter);

        countBefore= (int) responses.count();
        // removing years of experience nulls
        responses=responses.filter("YearsExp != 'null Yrs of Exp'");

        countAfter= (int) responses.count();

        System.out.print("\nBefore removing \"nulls years of exp\" number of rows:");
        System.out.println(countBefore);
        System.out.print(countBefore-countAfter);
        System.out.print(" \"nulls years of exp\" have been removed the new size is:");
        System.out.println(countAfter);

        countBefore= (int) responses.count();
        // removing any other nulls
        responses=responses.drop();

        countAfter= (int) responses.count();

        System.out.print("\nBefore removing nulls number of rows:");
        System.out.println(countBefore);
        System.out.print(countBefore-countAfter);
        System.out.print(" nulls have been removed the new size is:");
        System.out.println(countAfter);

        groupedDataset = responses.groupBy(col("Company"));
        System.out.println("\n=== Print the most demanding companies for jobs ===:\n");
        groupedDataset.count().orderBy(col("count").desc()).show();
        List<Row> datalist1=groupedDataset.count().orderBy(col("count").desc()).collectAsList();

        System.out.println("\n=== opening the 20 most demanding companies for jobs chart in another window ===:\n");
        SwingUtilities.invokeLater(() -> {
            CreatePieChart companiesChart = new CreatePieChart("the 20 most demanding companies for jobs",datalist1);
            companiesChart.setSize(800, 700);
            companiesChart.setLocationRelativeTo(null);
            companiesChart.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            companiesChart.setVisible(true);
        });

        groupedDataset = responses.groupBy(col("Title"));
        System.out.println("\n=== Print the most popular jobs' titles ===:\n");
        groupedDataset.count().orderBy(col("count").desc()).show();
        List<Row> datalist2= groupedDataset.count().orderBy(col("count").desc()).collectAsList();

        System.out.println("\n=== opening the most popular 20 jobs titles chart in another window ===:\n");
        CreateXchart chart2=new CreateXchart();
        chart2.createBarChart(datalist2,"the most popular 20 jobs titles","job title","job title counts","job titles");

        groupedDataset = responses.groupBy(col("Location"));
        System.out.println("\n=== Print the most popular job areas ===:\n");
        groupedDataset.count().orderBy(col("count").desc()).show();
        List<Row> datalist3=groupedDataset.count().orderBy(col("count").desc()).collectAsList();

        System.out.println("\n=== opening the most popular 20 job areas chart in another window ===:\n");
        CreateXchart chart3=new CreateXchart();
        chart3.createBarChart(datalist3,"the most popular 20 job areas","job areas","job areas counts","job titles");


        List<Row> allSkillsList= responses.select(col("skills")).collectAsList();
        List<String> skillsOneByOne= elementsOneByOne (allSkillsList);
        // write to csv
        csvWriter(skillsOneByOne,"SkillsOneByOne",        "skills_one_by_one_temp.csv");

        // open read session
        DataFrameReader skillsDfReader = session.read();
        Dataset<Row> skills = skillsDfReader.option("header", "true").csv("skills_one_by_one_temp.csv");

        RelationalGroupedDataset groupedskills;

        groupedskills = skills.groupBy(col("SkillsOneByOne"));
        System.out.println("\n=== Print the skills one by one ===:\n");
        groupedskills.count().orderBy(col("count").desc()).show();

        session.stop();

        try
        {
            Files.deleteIfExists(Paths.get("skills_one_by_one_temp.csv"));
        } catch (IOException e) { }

        session.stop();
    }

    public static List<String> elementsOneByOne (List<Row> allElementsList){
        List<String> skillsOneByOne= new ArrayList<>();
        for (int i =0;i<allElementsList.size();i++){
            String[] skillsSubArray = allElementsList.get(i).getString(0).split(",");
            skillsOneByOne.addAll(Arrays.asList(skillsSubArray));
        }
        return skillsOneByOne;
    }

    public static void csvWriter(List<String> lines,String header,String filepath) throws IOException {
        FileWriter writer = new FileWriter(filepath);

        writer.write(header+"\n");
        for (int i=0;i<lines.size();i++) {
            writer.write(lines.get(i).trim()+"\n");
        }
        writer.close();
    }



}