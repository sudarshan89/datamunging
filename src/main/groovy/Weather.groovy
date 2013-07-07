
/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 6/7/13
 * Time: 3:18 PM
 */

println "Hello Data Munging For wather.dat"

List<String> fileContent = getFileContent("/resources/weather.dat")
def pattern = ~/\d+/

int minSpread = 100
String dayWithMinimumTemperatureSpread = "Unknown"
fileContent.each {String line ->
    line = line.replaceAll("^\\s+","")
    if (isValidContent(line)){
        String day = pattern.matcher(line)[0]
        int maxTemp = Integer.valueOf(pattern.matcher(line)[1])
        String minimumTemp = pattern.matcher(line)[2]
        int minTemp = Integer.valueOf(minimumTemp.replace("*",""))
        int temperatureSpread = maxTemp - minTemp

        if (temperatureSpread <= minSpread){
            minSpread = temperatureSpread
            dayWithMinimumTemperatureSpread = day
        }

    }

}

                  println "The day with minimum Temperature spread is $dayWithMinimumTemperatureSpread"


List<String> getFileContent(String fileName){
    InputStream file = this.class.getResourceAsStream(fileName)
    String fileText = file.getText()
    return fileText.split("\n")

}

boolean isValidContent(String line) {
    return line.find("^\\d+")
}