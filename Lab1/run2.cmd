javac -d out src/CosHSeriesCalc.java

jar -cfe ./out/CosHSeriesCalc.jar CosHSeriesCalc -C ./out CosHSeriesCalc.class

java -jar ./out/CosHSeriesCalc.jar %*