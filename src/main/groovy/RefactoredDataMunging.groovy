import groovy.transform.Field

/**
 * Created by IntelliJ IDEA.
 * User: Nthdimenzion
 * Date: 7/7/13
 * Time: 12:46 PM
 */

int minSpread = 100
String entityWithMinimumSpread = "Unknown"

println "Hello Data Munging For wather.dat"
String fileName = "/resources/weather.dat"

List<String> fileContent = getFileContent(fileName)
Map<String,Integer> indexes = indexByFileName(fileName)

def minSpreadEntity = getMinSpreadEntityByFileName(fileName)

fileContent.each {String line ->
    line = line.replaceAll("^\\s+","")
    if (isValidContent(line)){
        int spread = dataSpread(line,indexes.maxIndex,indexes.minIndex)
        if (spread <= minSpread){
            minSpread = spread
            entityWithMinimumSpread = minSpreadEntity(line)

        }
    }
}

println "Minimum Spread is $minSpread for entity $entityWithMinimumSpread"

Map<String,Integer> indexByFileName(String fileName){
    if ("weather.dat" == fileName){
        return ["maxIndex":1,"minIndex":2]
    }else{
        return ["maxIndex":5,"minIndex":6]
    }
}

List<String> getFileContent(String fileName){
    InputStream file = this.class.getResourceAsStream(fileName)
    String fileText = file.getText()
    return fileText.split("\n")

}

boolean isValidContent(String line) {
    return line.find("^\\d+")
}

Integer dataSpread(String line,int maxIndex,int minIndex){
    def pattern = ~/\d+/
    int max = Integer.valueOf(pattern.matcher(line)[maxIndex])
    int min = Integer.valueOf(pattern.matcher(line)[minIndex])
    int spread = Math.abs(max - min)
    return spread
}

@Field def weatherEntity = {String line->
    def pattern = ~/\d+/
    return pattern.matcher(line)[0]
}

@Field def footballEntity = {String line->
    def teamPattern = ~/\d.{1}\s[aA-zZ]+/
    return teamPattern.matcher(line)[0]
}


def getMinSpreadEntityByFileName(String fileName) {
    if (fileName.contains("weather.dat")){
        return weatherEntity
    }else{
        return footballEntity
    }
}

