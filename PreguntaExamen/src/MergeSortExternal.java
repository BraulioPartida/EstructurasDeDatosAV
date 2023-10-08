import java.io.*;

public class MergeSortExternal {

    // Función para mezclar dos archivos ordenados
    public static void merge(String inputFile1, String inputFile2, String outputFile) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
        BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        while (line1 != null && line2 != null) {
            if (Integer.parseInt(line1) < Integer.parseInt(line2)) {
                writer.write(line1 + "\n");
                line1 = reader1.readLine();
            } else {
                writer.write(line2 + "\n");
                line2 = reader2.readLine();
            }
        }

        // Copiar el resto de elementos de inputFile1 (si quedan)
        while (line1 != null) {
            writer.write(line1 + "\n");
            line1 = reader1.readLine();
        }

        // Copiar el resto de elementos de inputFile2 (si quedan)
        while (line2 != null) {
            writer.write(line2 + "\n");
            line2 = reader2.readLine();
        }

        reader1.close();
        reader2.close();
        writer.close();
    }

    // Función principal para ordenar el archivo utilizando Merge Sort
    public static void externalMergeSort(String inputFile, String outputFile, int bufferSize) throws IOException {
        int runSize = bufferSize; // Tamaño inicial de los bloques (runs)
        int fileSize = 0;
        String tempFile1 = "temp1.txt";
        String tempFile2 = "temp2.txt";

        // Obtener el tamaño del archivo
        BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
        while (fileReader.readLine() != null) {
            fileSize++;
        }
        fileReader.close();

        while (runSize < fileSize) {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(tempFile2));

            String line;
            for (int i = 0; i < fileSize; i++) {
                line = reader.readLine();
                if (i < runSize) {
                    writer1.write(line + "\n");
                } else {
                    writer2.write(line + "\n");
                }
            }

            reader.close();
            writer1.close();
            writer2.close();

            // Mezclar los bloques (runs) y escribir en el archivo temporal
            BufferedReader runReader1 = new BufferedReader(new FileReader(tempFile1));
            BufferedReader runReader2 = new BufferedReader(new FileReader(tempFile2));

            BufferedWriter tempWriter = new BufferedWriter(new FileWriter(outputFile));

            String runLine1 = runReader1.readLine();
            String runLine2 = runReader2.readLine();

            while (runLine1 != null && runLine2 != null) {
                if (Integer.parseInt(runLine1) < Integer.parseInt(runLine2)) {
                    tempWriter.write(runLine1 + "\n");
                    runLine1 = runReader1.readLine();
                } else {
                    tempWriter.write(runLine2 + "\n");
                    runLine2 = runReader2.readLine();
                }
            }

            while (runLine1 != null) {
                tempWriter.write(runLine1 + "\n");
                runLine1 = runReader1.readLine();
            }

            while (runLine2 != null) {
                tempWriter.write(runLine2 + "\n");
                runLine2 = runReader2.readLine();
            }

            tempWriter.close();
            runReader1.close();
            runReader2.close();

            // Incrementar el tamaño de los bloques (runs)
            runSize *= 2;
        }

        // Renombrar el archivo ordenado final
        File sortedFile = new File(outputFile);
        File originalFile = new File(inputFile);
        originalFile.delete();
        sortedFile.renameTo(originalFile);
    }

    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\brown\\OneDrive\\Desktop\\I\\Escuela\\Informatica\\Netbeans\\DatosUwU\\EstructurasDeDatosAV\\PreguntaExamen\\n"
                + //
                "umeros_desordenados.txt"; // Nombre del archivo de entrada
        String outputFile = "C:\\Users\\brown\\OneDrive\\Desktop\\I\\Escuela\\Informatica\\Netbeans\\DatosUwU\\EstructurasDeDatosAV\\PreguntaExamen\\salida.txt"; // del
        // archivo
        // de
        // salida
        int bufferSize = 100; // Tamaño del búfer para la lectura/escritura

        // Llamar a la función para ordenar el archivo externamente
        externalMergeSort(inputFile, outputFile, bufferSize);
        System.out.println("Archivo ordenado y guardado como " + outputFile);
    }
}
