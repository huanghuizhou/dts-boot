package com.hhz.demo.util;

import com.hhz.demo.model.UserTest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ExcelUtil {

    public static void main(String[] args) throws IOException {
        ArrayList aa = new ArrayList();
        int d = aa.size();
        FileInputStream fis = new FileInputStream("/Users/hhz/test/测试.xlsx");
        //指定每列对应的类属性
        LinkedHashMap<String, String> alias = new LinkedHashMap<>();
        alias.put("编号", "id");
        alias.put("姓名", "name");
        alias.put("年龄", "age");
        //转换成指定类型的对象数组
        List<UserTest> pojoList = ExcelUtil.excel2Pojo(fis, UserTest.class, alias);
        System.out.println(111);
    }

    public static <T> List<T> excel2Pojo(InputStream inputStream, Class<T> claz, LinkedHashMap<String, String> alias) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        try {
            XSSFSheet sheet = wb.getSheetAt(0);

            //生成属性和列对应关系的map，Map<类属性名，对应一行的第几列>
            Map<String, Integer> propertyMap = generateColumnPropertyMap(sheet, alias);
            //根据指定的映射关系进行转换
            List<T> pojoList = generateList(sheet, propertyMap, claz);
            return pojoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            wb.close();
        }
    }

    /**
     * 生成一个属性-列的对应关系的map
     *
     * @param sheet 表
     * @param alias 别名
     * @return
     */
    private static Map<String, Integer> generateColumnPropertyMap(XSSFSheet sheet, LinkedHashMap<String, String> alias) {
        Map<String, Integer> propertyMap = new HashMap<>();

        XSSFRow propertyRow = sheet.getRow(0);
        short firstCellNum = propertyRow.getFirstCellNum();
        short lastCellNum = propertyRow.getLastCellNum();

        for (int i = firstCellNum; i < lastCellNum; i++) {
            Cell cell = propertyRow.getCell(i);
            if (cell == null) {
                continue;
            }
            //列名
            String cellValue = cell.getStringCellValue();
            //对应属性名
            String propertyName = alias.get(cellValue);
            propertyMap.put(propertyName, i);
        }
        return propertyMap;
    }

    /**
     * 根据指定关系将表数据转换成对象数组
     *
     * @param sheet       表
     * @param propertyMap 属性映射关系Map<"属性名",一行第几列>
     * @param claz        类类型
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static <T> List<T> generateList(XSSFSheet sheet, Map<String, Integer> propertyMap, Class<T> claz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        //对象数组
        List<T> pojoList = new ArrayList<>();
        for (Row row : sheet) {
            //跳过前两行标题和列名
            if (row.getRowNum() < 1) {
                continue;
            }
            T instance = claz.newInstance();
            Set<Map.Entry<String, Integer>> entrySet = propertyMap.entrySet();
            for (Map.Entry<String, Integer> entry : entrySet) {
                //获取此行指定列的值,即为属性对应的值
                Cell cell = row.getCell(entry.getValue());
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String property = cell.getStringCellValue();
                BeanUtils.setProperty(instance, entry.getKey(), property);
            }
            pojoList.add(instance);
        }
        return pojoList;
    }


}
