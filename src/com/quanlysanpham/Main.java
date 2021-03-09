package com.quanlysanpham;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

//        Product product1 = new Product("1", "1", 1, 4, "a");
//        Product product2 = new Product("2", "2", 5, 2, "a");
//        Product product3 = new Product("3", "3", 2, 3, "a");
//        Product product4 = new Product("4", "4", 3, 9, "a");
//        Product product5 = new Product("5", "5", 5, 4, "a");
//        Product product6 = new Product("6", "6", 0, 2, "a");
//        Product product7 = new Product("7", "7", 5, 3, "a");
//        Product product8 = new Product("8", "8", 3, 9, "a");
//
//        productManager.listProduct.add(product1);
//        productManager.listProduct.add(product2);
//        productManager.listProduct.add(product3);
//        productManager.listProduct.add(product4);
//        productManager.listProduct.add(product5);
//        productManager.listProduct.add(product6);
//        productManager.listProduct.add(product7);
//        productManager.listProduct.add(product8);

        int choose;

        try {
            do {
                showMenu();
                choose = Integer.parseInt(input.nextLine());

                switch (choose) {
                    case 1:
                        productManager.displayProduct();
                        break;
                    case 2:
                        productManager.addProduct();
                        break;
                    case 3:
                        productManager.editProduct();
                        break;
                    case 4:
                        productManager.deleteProduct();
                        break;
                    case 5:
                        productManager.sortProduct();
                        break;
                    case 6:
                        productManager.findMaxvalue();
                        break;
                    case 7:
                        productManager.readFile();
                        break;
                    case 8:
                        productManager.writerFile();
                        break;
                    case 9:
                        System.out.println("Goodbye!!!");
                        break;
                    default:
                        System.out.println("Lựa chọn ngoài phạm vi!!!");
                }

            } while (choose != 9);

        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Lựa chọn sai định dạng!!!");
        }
    }

    public static void showMenu() {
        System.out.println("\n---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
