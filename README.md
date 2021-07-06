# WuzzufServey
Wuzzuf dataset survey    
## Overview:
This project is a cleaning and analysis to Wuzzuf survey using Java, Spark and XChart

## Dataset:
https://www.kaggle.com/omarhanyy/wuzzuf-jobs

## Steps:
* Display structure and summary of the data   
* Data cleaning remove nulls and duplications   
* Display jobs count for each company in order and show it in a pie chart   
* Display the frequency of jobs demands in each country and show it in a bar chart   
* Display the most popular areas in order and show it in a bar chart   
* Display the most popular required skills one by one   

## Notes:   
to Run this project please download all the java files and keep the wuzzuf_jobs.csv file in the main main project folder 

## Outputs:
=== Print 20 records of responses table ===:    
    
+--------------------+--------------------+-----------+----------+-------------------+---------------+-------+--------------------+    
|               Title|             Company|   Location|      Type|              Level|       YearsExp|Country|              Skills|    
+--------------------+--------------------+-----------+----------+-------------------+---------------+-------+--------------------+    
|Customer Service ...|    Johnson Controls|  New Cairo| Full Time|        Entry Level| 1-3 Yrs of Exp|  Cairo|Call Center, Cust...|    
|   Marketing Manager|SYE English Commu...|      Dokki| Full Time|            Manager|5-10 Yrs of Exp|   Giza|Market Research, ...|    
|Medical Represent...|     So Value Pharma|      Cairo| Full Time|        Entry Level| 0-5 Yrs of Exp|  Egypt|Cardio-metabolic,...|    
|Order Handling Sp...|    Johnson Controls|  New Cairo| Full Time|        Experienced| 3-5 Yrs of Exp|  Cairo|Supply Officer, S...|    
|         Storekeeper|        Confidential|      Cairo| Full Time|        Experienced|  3+ Yrs of Exp|  Egypt|Warehousing, Stor...|    
|Senior .NET Devel...|               Dexef|      Maadi| Full Time|        Experienced| 3-5 Yrs of Exp|  Cairo|ASP.NET, Desktop ...|    
|Preschool French ...|Leap Development Hub|  New Cairo| Full Time|        Entry Level| 1-3 Yrs of Exp|  Cairo|Education, Educat...|    
|Junior Business D...|E3mel Business fo...|      Maadi| Full Time|        Entry Level| 1-3 Yrs of Exp|  Cairo|Sales Target, Sal...|    
|Indoor Sales Exec...|         Line Design|  Nasr City| Full Time|        Experienced| 1-3 Yrs of Exp|  Cairo|sales skills, Sal...|    
|Content Creator /...|            EL KHETA| Alexandria| Full Time|        Entry Level|  1+ Yrs of Exp|  Egypt|Copywriter, SEO, ...|    
|STEAM Instructor ...|             BeSteam|  Nasr City|Internship|            Student|null Yrs of Exp|  Cairo|Education, Traini...|    
|English Instructo...|             Speakup|     Helwan| Part Time|Freelance / Project| 1-5 Yrs of Exp|  Cairo|3 Vacancies, Male...|    
|      Lawyer - Cairo|      Bayt El Khebra|      Maadi| Full Time|        Experienced| 15+ Yrs of Exp|  Cairo|legal, lawyer, Legal|    
|Site Supervisor م...|      ZDS Architects|      Cairo| Full Time|        Experienced|  2+ Yrs of Exp|  Egypt|Architecture, Eng...|    
|Junior Personnel ...|    El-Moasser Books|  Nasr City| Full Time|        Entry Level| 1-2 Yrs of Exp|  Cairo|Human Resources (...|    
|    Floor controller|           Atheel CC|      Cairo| Full Time|        Entry Level|null Yrs of Exp|  Egypt|Communication Ski...|    
|Procurement Speci...|      ZDS Architects|      Cairo| Full Time|        Experienced|  3+ Yrs of Exp|  Egypt|Construction, Com...|    
|        Receptionist|           Atheel CC|      Cairo| Full Time|        Entry Level|null Yrs of Exp|  Egypt|Administration, O...|    
|Product Manager -...|           Silicon21|  Nasr City| Full Time|Freelance / Project| 3-5 Yrs of Exp|  Cairo|Electronics, Info...|    
|Resident Engineer...|           Silicon21|  Nasr City| Full Time|        Entry Level| 1-2 Yrs of Exp|  Cairo|Telecom, IT, Comp...|    
+--------------------+--------------------+-----------+----------+-------------------+---------------+-------+--------------------+    
only showing top 20 rows    
    
    
=== Print out schema (structure and summary) ===:    
    
root    
 |-- Title: string (nullable = true)    
 |-- Company: string (nullable = true)    
 |-- Location: string (nullable = true)    
 |-- Type: string (nullable = true)    
 |-- Level: string (nullable = true)    
 |-- YearsExp: string (nullable = true)    
 |-- Country: string (nullable = true)    
 |-- Skills: string (nullable = true)    
    

=== Print out data cleaning results ===:    
    
                                                                                    
Before removing duplicates number of rows:4380    
3 duplicates have been removed the new size is:4377    
                                                                                    
Before removing "nulls years of exp" number of rows:4377    
62 "nulls years of exp" have been removed the new size is:4315    
                                                                                    
Before removing nulls number of rows:4315    
0 nulls have been removed the new size is:4315    
    
=== Print the most demanding companies for jobs ===:    
    
+--------------------+-----+    
|             Company|count|    
+--------------------+-----+    
|        Confidential|  588|    
|        Mishkat Nour|   39|    
|         Expand Cart|   35|    
|                EGIC|   34|    
|         Aqarmap.com|   25|    
|       Majorel Egypt|   23|    
|Ghassan Ahmed Als...|   21|    
|          Flairstech|   18|    
| Profolio Consulting|   17|    
|          OPPO Egypt|   16|    
|Premier Services ...|   15|    
|             4level1|   15|    
|Cleopatra Hospita...|   14|    
|               Nagwa|   14|    
|SYE English Commu...|   13|    
|Nahdet Misr Publi...|   13|    
| Raya Contact Center|   12|    
|     Andalusia Group|   11|    
|             Sumerge|   11|    
|  Virtual Worker Now|   11|    
+--------------------+-----+    
only showing top 20 rows    
    
                                                                                    
=== opening the 20 most demanding companies for jobs chart in another window ===:    
![alt text](https://github.com/mohamedsalman-git/WuzzufServey/blob/fcc8e22d8534338081a62c42f36ec8427003d52f/the%20most%20demanding%20companies%20for%20jobs%20pie%20chart.PNG?raw=true)
    
    
=== Print the most popular jobs' titles ===:    
    
+--------------------+-----+    
|               Title|count|    
+--------------------+-----+    
|          Accountant|   56|    
|Sales Representative|   47|    
|    Graphic Designer|   43|    
|Digital Marketing...|   26|    
|       Sales Manager|   25|    
|Social Media Spec...|   23|    
|        Receptionist|   22|    
| Executive Secretary|   20|    
|     Sales Executive|   18|    
|Marketing Specialist|   17|    
|      Sales Engineer|   16|    
|     Project Manager|   16|    
|   Senior Accountant|   16|    
|   Marketing Manager|   16|    
|     Telesales Agent|   16|
|Business Developm...|   15|        
|Senior Graphic De...|   15|    
|       HR Generalist|   15|    
|      Office Manager|   14|    
| Property Consultant|   13|    
+--------------------+-----+    
only showing top 20 rows    
    
                                                                                
=== opening the most popular 20 jobs titles chart in another window ===:    
![alt text](https://github.com/mohamedsalman-git/WuzzufServey/blob/master/the%20most%20popular%2020%20job%20title%20bar%20chart.PNG?raw=true)
    
=== Print the most popular job areas ===:    
    
+--------------------+-----+    
|            Location|count|    
+--------------------+-----+    
|               Cairo|  547|    
|               Maadi|  517|    
|           New Cairo|  516|    
|           Nasr City|  422|    
|      6th of October|  278|    
|          Heliopolis|  243|    
|               Dokki|  138|    
|         Mohandessin|  136|        
|          Alexandria|  129|    
|                Giza|  126|    
| 10th of Ramadan ...|  108|    
|            Sheraton|  103|    
|        Sheikh Zayed|   76|    
|          Obour City|   73|    
|            Downtown|   42|    
|            Mokattam|   39|    
|              Riyadh|   36|    
|               Haram|   34|    
|        Bourj Alarab|   31|    
|             Zamalek|   30|    
+--------------------+-----+    
only showing top 20 rows    
    
                                                                                    
=== opening the most popular 20 job areas chart in another window ===:    
![alt text](https://github.com/mohamedsalman-git/WuzzufServey/blob/master/the%20most%20popular%2020%20job%20area%20bar%20chart.PNG?raw=true)
                                                                                    
=== Print the skills one by one ===:    
    
+--------------------+-----+    
|      SkillsOneByOne|count|    
+--------------------+-----+    
|             English| 1254|    
|        Sales Skills|  767|    
|        Sales Target|  698|    
|    Computer Science|  678|    
|        Sales/Retail|  647|    
|    Microsoft Office|  577|    
|Information Techn...|  572|    
|    Customer Service|  567|    
|      Administration|  528|    
|Communication Skills|  449|    
|Software Development|  356|    
|    Customer Support|  345|    
|       Customer Care|  335|    
|  Accounting/Finance|  303|    
|             Finance|  298|    
|Customer Service/...|  284|    
|  Financial Analysis|  276|    
|Marketing/PR/Adve...|  256|    
|        Social Media|  250|    
|Business Development|  248|    
+--------------------+-----+    
only showing top 20 rows        
