# MOJAthenaUDFs
### AWS ATHENA UDFs for Record Linkage

Need Java 1.8 / Maven installed. Installation of both through SDKMAN is recommended



### HOW TO BUILD JAR:


    mvn package clean #to check if it compiles
    mvn clean install -DskipTests

Create a lambda function (make sure that lambda role is created before this)

    aws lambda create-function
    --function-name athenaudf
    --runtime java8
    --role arn:aws:iam::3242345446345:role/serverlessrepo-AthenaUserDefin
    --handler com.awssupport.athena.udfs.MOJAthenaUserDefinedFunctions
    --timeout 900
    --zip-file fileb://./target/MOJAthenaUserDefinedFunctions-1.0-SNAPSHOT --region eu-west-1

Go to Athena and make sure that Console is pointing to Engine version 2

Run below query to test UDF

`USING EXTERNAL FUNCTION compress(input VARCHAR) RETURNS VARCHAR LAMBDA 'athenaudf' SELECT compress('Hello')`
