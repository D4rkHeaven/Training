package lopatin.structural.decorator;

public class Main {
    public static void main(String[] args) {
        String testRecord = "Test record\nTest record 2";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/output.txt")));
        encoded.writeData(testRecord);
        DataSource dataSource = new FileDataSource("out/output.txt");

        System.out.println("- Input -");
        System.out.println(testRecord);
        System.out.println("- Encoded -");
        System.out.println(dataSource.readData());
        System.out.println("- Decoded -");
        System.out.println(encoded.readData());
    }
}
