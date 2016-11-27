# Draumaradningar

### Java forrit eru staðsett í draumaradningar/src/main/java/DreamDiary/
### HTML/CSS/js eru staðsett í draumaradningar/src/main/resources/templates

#### Keyrist á skipanalínu svona (gradle þarf að vera installað):
+ farðu inní möppuna draumaradningar
+ skrifaðu gradle build
+ skrifaðu gradle wrapper
+ skrifaðu ./gradlew bootRun
+ þá er þetta aðgengilegt á localhost:8080/
+ skrifaðu gradle clean  til ad eyda öllum build skram (möppunni draumaradningar/build/)
+ please CLEAN before committing to github

#### SQL töflur:
+ create table dreams2 (id serial, userid int, date Date, name varchar(50), content varchar(500), interpretation varchar(500));
+ create table users2 (id serial, name varchar(50), password varchar(50));