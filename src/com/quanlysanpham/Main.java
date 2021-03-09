package com.quanlysanpham;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        productManager.listProduct.add(new Product("1", "1", 1, 4, "a"));
        productManager.listProduct.add(new Product("2", "2", 5, 2, "a"));
        productManager.listProduct.add(new Product("3", "3", 2, 3, "a"));
        productManager.listProduct.add(new Product("4", "4", 3, 9, "a"));
        productManager.listProduct.add(new Product("5", "5", 5, 4, "a"));
        productManager.listProduct.add(new Product("6", "6", 0, 2, "a"));
        productManager.listProduct.add(new Product("7", "7", 5, 3, "a"));
        productManager.listProduct.add(new Product("8", "8", 3, 9, "a"));

        int choose;
        while (true) {
            try {
                while(true) {
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
                            System.exit(1);
                        default:
                            System.out.println("Lựa chọn ngoài phạm vi!!!");
                    }
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Lựa chọn sai định dạng!!!");
            }
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
