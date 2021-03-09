package com.quanlysanpham;

import java.io.*;
import java.util.*;

public class ProductManager {
    ArrayList<Product> listProduct = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public ProductManager() {

    }

    public void displayProduct() {
        if (listProduct.isEmpty()) {
            System.err.println("Danh sách trống!!!");
            return;
        }
        boolean isLoop = true;
        int start = 0;
        int end = 4;
        System.out.println("Chọn 1 để thêm mới, Enter để xem tiếp");
        Scanner scanner = new Scanner(System.in);

        while (isLoop) {
            for (int i=start; i<=end; i++) {
                if (i>listProduct.size()-1) {
                    break;
                }
                System.out.println("STT "+(i+1)+": "+listProduct.get(i).display());
            }
            if (end>=listProduct.size()-1) break;
            start+=5;
            end+=5;

            String check = scanner.nextLine();
            if (check.equalsIgnoreCase("1")) {
                addProduct();
                isLoop = false;
            }
        }
    }

    public void addProduct() {
        Product product = new Product();

        inputProduct(product);

        listProduct.add(product);
        System.out.println("Đã thêm sản phẩm thành công");
    }

    public void editProduct() {
        if (listProduct.isEmpty()) {
            System.err.println("Danh sách trống!!!");
            return;
        }
        while (true) {
            System.out.print("Nhập mã sản phẩm cần sửa: ");
            String idFind = input.nextLine();
            boolean isFind = true;
            boolean isEdit = true;

            if (idFind.isEmpty()) {
                break;
            } else {
                for (Product product : listProduct) {
                    if (product.getId().equalsIgnoreCase(idFind)) {
                        inputProduct(product);

                        System.out.println("Đã cập nhật sản phẩm thành công");
                        isFind = false;
                        isEdit = false;
                        break;
                    }
                }
                if (isFind) {
                    System.err.println("Không tìm được sản phẩm với mã sản phẩm trên");
                }
            }
            if (!isEdit) break;
        }
    }

    public void deleteProduct() {
        if (listProduct.isEmpty()) {
            System.err.println("Danh sách trống!!!");
            return;
        }
        while (true) {
            System.out.print("Nhập mã sản phẩm muốn xóa: ");
            String idFind = input.nextLine();
            boolean isFind = true;
            boolean isEdit = true;

            if (idFind.isEmpty()) {
                break;
            } else {
                for (Product product : listProduct) {
                    if (product.getId().equalsIgnoreCase(idFind)) {
                        System.out.print("Bạn chắc chắn muốn xóa sản phẩm -> Y?");
                        String chosse = input.nextLine();
                        if (chosse.equalsIgnoreCase("Y")) {
                            listProduct.remove(product);

                            System.out.println("Đã xóa sản phẩm thành công");
                            isFind = false;
                            isEdit = false;
                            break;
                        }
                        isFind = false;
                        isEdit = false;
                    }
                }
                if (isFind) {
                    System.err.println("Không tìm được sản phẩm với mã sản phẩm trên");
                }
            }
            if (!isEdit) break;
        }
    }

    public void sortProduct() {
        if (listProduct.isEmpty()) {
            System.err.println("Danh sách trống!!!");
            return;
        }
        System.out.println("Chọn 1 để sắp xếp theo giá tăng dần: ");
        System.out.println("Chọn 2 để sắp xếp theo giá giảm dần: ");
        System.out.println("Chọn 3 để quay lại");

        int choose = Integer.parseInt(input.nextLine());

        switch (choose) {
            case 1:
                Collections.sort(listProduct, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice() - o2.getPrice();
                    }
                });
                System.out.println("Sắp xếp thành công");
                break;
            case 2:
                Collections.sort(listProduct, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getPrice() - o1.getPrice();
                    }
                });
                System.out.println("Sắp xếp thành công");
                break;
            case 3:
                break;
            default:
                System.err.println("Lựa chọn ngoài phạm vi!!!");
                break;
        }
    }

    public void findMaxvalue() {
        if (listProduct.isEmpty()) {
            System.err.println("Danh sách trống!!!");
            return;
        }
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });

        System.out.println(listProduct.get(0).display());

        int max = listProduct.get(0).getPrice();
        int indexMax = 0;
        boolean isMax = true;
        for (int k=0; k<listProduct.size()-1 && isMax; k++) {
            for (int i = k+1; i < listProduct.size(); i++) {
                if (listProduct.get(i).getPrice() >= max) {
                    max = listProduct.get(i).getPrice();
                    indexMax = i;
                    isMax = true;
                    break;
                }
                isMax = false;
            }
            if (isMax) {
                System.out.println(listProduct.get(indexMax).display());
            }
        }
    }

    public void readFile() {
        try {
            System.out.println("Đọc từ file sẽ xóa và cập nhật lại toàn bộ nội dung sản phẩm");
            System.out.println("Nhấn Enter để tiếp tục");
            String choose = input.nextLine();

            if (choose.isEmpty()) {
                File file = new File(".\\data\\source.csv");

                if (!file.exists()) {
                    throw new FileNotFoundException();
                }

                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                String line = bufferedReader.readLine();

                listProduct.clear();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(",");
                    Product product = new Product();

                    product.setId(words[0]);
                    product.setName(words[1]);
                    int price = Integer.parseInt(words[2]);
                    product.setPrice(price);
                    int quantity = Integer.parseInt(words[3]);
                    product.setQuantity(quantity);
                    product.setDescription(words[4]);

                    listProduct.add(product);
                }
                bufferedReader.close();
                System.out.println("Đọc từ file thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writerFile() {
        if (listProduct.isEmpty()) {
            System.err.println("Danh sách trống!!!");
            return;
        }
        System.out.println("Ghi vào file sẽ cập nhật lại toàn bộ nội dung file");
        System.out.println("Nhấn Enter để tiếp tục");
        String choose = input.nextLine();
        if (choose.isEmpty()) {
            try {
                FileWriter fileWriter = new FileWriter(".\\data\\products.csv");

                fileWriter.write("Mã sản phẩm,Tên,Giá,Số lượng,Mô tả\n");
                for (Product product : listProduct) {
                    fileWriter.write(product + "\n");
                }

                fileWriter.close();
                System.out.println("Ghi file thành công");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inputProduct(Product product) {
        System.out.print("Nhập mã sản phẩm: ");
        while (true) {
            String id = input.nextLine();
            if (id.isEmpty()) {
                System.err.print("Nhập mã sản phẩm (không được để trống): ");
            } else {
                boolean isExist = true;
                for (Product element: listProduct) {
                    if (element.getId().equalsIgnoreCase(id)) {
                        System.err.print("Mã sản phẩm đã tồn tại! Nhập lại mã sản phẩm: ");
                        isExist = false;
                        break;
                    }
                }
                if (isExist) {
                    product.setId(id);
                    break;
                }
            }
        }

        System.out.print("Nhập tên sản phẩm: ");
        while (true) {
            String name = input.nextLine();
            if (!name.isEmpty()) {
                product.setName(name);
                break;
            }
            System.err.print("Nhập tên sản phẩm (không được để trống): ");
        }

        System.out.print("Nhập giá sản phẩm: ");
        while (true) {
            try {
                String temp = input.nextLine();
                if (!temp.isEmpty()) {
                    int price = Integer.parseInt(temp);
                    product.setPrice(price);
                    break;
                }
                System.err.print("Nhập giá sản phẩm (không được để trống): ");
            } catch (NumberFormatException e) {
                System.err.print("Nhập sai định dạng! Nhập lại giá sản phẩm: ");
            }
        }

        System.out.print("Nhập số lượng sản phẩm: ");
        while (true) {
            try {
                String temp = input.nextLine();
                if (!temp.isEmpty()) {
                    int quantity = Integer.parseInt(temp);
                    product.setQuantity(quantity);
                    break;
                }
                System.err.print("Nhập số lượng sản phẩm (không được để trống): ");
            } catch (NumberFormatException e) {
                System.err.print("Nhập sai định dạng! Nhập lại số lượng sản phẩm: ");
            }
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        while (true) {
            String description = input.nextLine();
            if (!description.isEmpty()) {
                product.setDescription(description);
                break;
            }
            System.err.print("Nhập mô tả sản phẩm (không được để trống): ");
        }
    }
}
