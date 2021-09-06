package ku.cs.services;

// T - Generic Type
public interface DataSource<T> {
     T readData();
     void writeData(T t);
}
