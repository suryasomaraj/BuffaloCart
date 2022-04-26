package com.buffalocart.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableUtility {
    public List<ArrayList<String>> getGridData(List<WebElement> rowItems, List<WebElement> columnItems) {
        int rowSize = rowItems.size() - 1;
        int cellSize = columnItems.size();
        int columnListSize = (cellSize / rowSize);
        System.out.println("rowSize =" + rowSize + "  cellSize=" + cellSize + "  columnListSize= " + columnListSize);
        String[] columnList = new String[columnListSize]; // 20/5 --->4
        List<ArrayList<String>> gridData = new ArrayList<ArrayList<String>>();
        int x = 0;
        int s = columnList.length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnList.length; j++) {
                columnList[j] = columnItems.get(x).getText();
                x++;
            }
            gridData.add(new ArrayList<String>(Arrays.asList(columnList)));
        }
        return gridData;
    }
}
