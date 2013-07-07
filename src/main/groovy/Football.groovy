
/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 7/7/13
 * Time: 12:16 PM
 */
println "Hello Data Munging For wather.dat"

List<String> fileContent = getFileContent("/resources/football.dat")
def pattern = ~/\d+/

def teamPattern = ~/\d.{1}\s[aA-zZ]+/

int minSpread = 100
String teamWithMinimumGoalSpread = "Unknown"
fileContent.each {String line ->
    line = line.replaceAll("^\\s+","")
    if (isValidContent(line)){
        int forGoals = Integer.valueOf(pattern.matcher(line)[5])
        int againstGoals = Integer.valueOf(pattern.matcher(line)[6])
        int goalSpread = Math.abs(forGoals - againstGoals)
        String team = teamPattern.matcher(line)[0]
        //println "forGoals $forGoals  againstGoals  $againstGoals    goalSpread   $goalSpread "

        if (goalSpread <= minSpread){
            minSpread = goalSpread
            teamWithMinimumGoalSpread = team
        }

    }
}

println "The day with minimum Temperature spread is $teamWithMinimumGoalSpread"

List<String> getFileContent(String fileName){
    InputStream file = this.class.getResourceAsStream(fileName)
    String fileText = file.getText()
    return fileText.split("\n")

}

boolean isValidContent(String line) {
    return line.find("^\\d+")
}