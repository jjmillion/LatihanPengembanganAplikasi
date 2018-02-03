import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
 
public class TestCoffeeShop2 {
    public static void main(String []args) {
        // products
        Map<String, Product> products = new HashMap<>();
       
        products.put("capuccinno", new Product("Capuccinno", 20000.0));
        products.put("americano", new Product("Americano", 15000.0));
        products.put("latte", new Product("Lattet", 22000.0));
        products.put("espresso", new Product("Espresso", 25000.0));
        products.put("padi", new Product("Teh Pahit Dingin", 2000.0 ));
        products.put("mandi", new Product("Teh Manis Dingin", 4000.0 ));
       
        // Data Penjualan
        List<FakturPenjualan> penjualan = new ArrayList<>();
       
        List<Entry<Product, Integer>> items;        
        penjualan.add(new FakturPenjualan(LocalDate.of(2018, 1, 30),
                Arrays.asList(new SimpleEntry(products.get("capuccinno"), 2))
        ));
       
        penjualan.add(new FakturPenjualan(LocalDate.of(2018, 1, 30),
                Arrays.asList(new SimpleEntry(products.get("latte"), 1),
                        new SimpleEntry(products.get("capuccinno"), 2),
                        new SimpleEntry(products.get("mandi"), 1))
        ));
       
        penjualan.add(new FakturPenjualan(LocalDate.of(2018, 1, 27),
                Arrays.asList(new SimpleEntry(products.get("espresso"), 1),
                        new SimpleEntry(products.get("americano"), 1))
        ));
       
        penjualan.add(new FakturPenjualan(LocalDate.of(2018, 1, 28),
                Arrays.asList(new SimpleEntry(products.get("mandi"), 2),
                        new SimpleEntry(products.get("padi"), 1))
        ));
       
        penjualan.add(new FakturPenjualan(LocalDate.of(2018, 1, 27),
                Arrays.asList(new SimpleEntry(products.get("americano"), 2),
                        new SimpleEntry(products.get("capuccinno"), 1))
        ));
       
        penjualan.add(new FakturPenjualan(LocalDate.of(2018, 1, 29),
                Arrays.asList(new SimpleEntry(products.get("mandi"), 4))
        ));
       
        penjualan.add(new FakturPenjualan(LocalDate.of(2018, 1, 26),
                Arrays.asList(new SimpleEntry(products.get("mandi"), 2),
                        new SimpleEntry(products.get("capuccinno"), 1),
                        new SimpleEntry(products.get("americano"), 1),
                        new SimpleEntry(products.get("latte"), 1))
        ));
       
        penjualan.add(new FakturPenjualan(LocalDate.of(2018, 1, 26),
                Arrays.asList(new SimpleEntry(products.get("padi"), 1),
                        new SimpleEntry(products.get("latte"), 2)
                        )
        ));
       
        // all penjualan
        for (FakturPenjualan faktur: penjualan) {
            for (Entry<Product, Integer> item: faktur.getItems()) {
                System.out.println(item.getKey() + "\t: " + item.getValue());
            }
        }
        
        for (FakturPenjualan faktur: penjualan) {
            System.out.println("Tanggal:\t"+faktur.getTanggal());
            for (Entry<Product,Integer>item : faktur.getItems()){
                Product p = item.getKey();
                Integer qty = item.getValue();
                Double subtotal = p.getHarga()*qty;
                System.out.printf("%20s %10s %10s %10s %n","Nama","Harga","Qty","Subtotal");
                System.out.printf("%20s %,10.0f %,10d %,10.0f %n%n",p.getNama(),p.getHarga(),qty,subtotal);
            }
        }
        

    }
}