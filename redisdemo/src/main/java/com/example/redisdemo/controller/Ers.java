//package com.example.redisdemo.controller;
//
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.WriterException;
//import com.google.zxing.common.BitMatrix;
//
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * com.xinguangnet.tuchao.merchant.manage
// *
// * @Author : Wukn
// * @Date : 2018/2/5
// */
//public class Ers {
//
//    public static void main(String[] args) throws WriterException {
//        String filePath = "D://";
//        String fileName = "zxing.png";
//        String content = "测试zxing生成二维码";
//        int width = 300; // 图像宽度
//        int height = 300; // 图像高度
//        String format = "png";// 图像类型
//        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
//        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
//                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
//        Path path = FileSystems.getDefault().getPath(filePath, fileName);
//        System.out.println("输出成功.");
//    }
//}
