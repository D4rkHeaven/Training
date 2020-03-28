package lopatin.structural.decorator;

public class DataSourceDecorator implements DataSource {
    private DataSource wrapped;

    DataSourceDecorator(DataSource source) {
        this.wrapped = source;
    }

    @Override
    public void writeData(String data) {
        wrapped.writeData(data);
    }

    @Override
    public String readData() {
        return wrapped.readData();
    }
}
