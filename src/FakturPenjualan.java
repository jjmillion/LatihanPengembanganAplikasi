import java.time.LocalDate;
import java.util.List;
import java.util.Map.Entry;


public class FakturPenjualan {
        private LocalDate tanggal;
        private List<Entry<Product,Integer>> items;

    public FakturPenjualan(LocalDate tanggal, List<Entry<Product, Integer>> items) {
        this.tanggal = tanggal;
        this.items = items;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public List<Entry<Product,Integer>>getItems(){
        return items;
    }
}