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

update 19/11
Spring Security now in play. Not connected to user database for authentication yet so only single user able to login:
user - password