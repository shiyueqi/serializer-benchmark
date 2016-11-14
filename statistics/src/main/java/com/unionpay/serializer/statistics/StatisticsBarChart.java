package com.unionpay.serializer.statistics;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.io.IOException;

/**
 * date: 2016/11/04 14:56.
 * author: Yueqi Shi
 */
public class StatisticsBarChart {

    /**
     * 生成柱状图
     */
    public static void makeStatisticsBarChart3D(StatisticsType statisticsType) {

        // 获得数据集
        CategoryDataset dataset = DataService.getStatisticsDataSet(statisticsType);

        //JFreeChart 绘图
        JFreeChart chart = ChartFactory.createBarChart3D(
                statisticsType.getDescription(),                            // 图表标题
                statisticsType.getCategoryAxisLabel(),                      // 目录轴的显示标签
                statisticsType.getValueAxisLabel(),                         // 数值轴的显示标签
                dataset,                                                    // 数据集
                PlotOrientation.VERTICAL,                                   // 图表方向：水平、垂直
                true,                                                       // 是否显示图例
                true,                                                       // 是否生成工具（提示）
                true                                                        // 是否生成URL链接
        );
        // 设置标题字体
        Font font = new Font("楷体", Font.BOLD, 28);
        TextTitle textTitle = new TextTitle(statisticsType.getDescription());
        textTitle.setFont(font);
        chart.setTitle(textTitle);
        chart.setTextAntiAlias(false);
        // 设置背景色
        //Image image=new Image("/1.png");
        //Image img = ImageIO.read(new File("d:/1.jpg"));
        //chart.getCategoryPlot().setBackgroundImage(img);
        //chart.setForegroundPaint(new Color(0, 0, 0));
        chart.getCategoryPlot().setForegroundAlpha(0.9F);
        // 设置图例字体

        LegendTitle legend = chart.getLegend(0);
        legend.setItemFont(new Font("宋体", Font.TRUETYPE_FONT, 14));
        // 获得柱状图的Plot对象
        CategoryPlot plot = chart.getCategoryPlot();
        // 取得横轴
        CategoryAxis categoryAxis = plot.getDomainAxis();
        // 设置横轴显示标签的字体
        categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 16));
        // 设置横轴标记的字体
        categoryAxis.setTickLabelFont(new Font("宋休", Font.TRUETYPE_FONT, 10));
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        // 取得纵轴
        NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
        // 设置纵轴显示标签的字体
        numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 16));
        //设置图片区与坐标轴的距离
        //plot.setAxisOffset(new RectangleInsets(5.0, -5.0, 2.0, 0.0));
        //设置柱体颜色
        BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        //设置外廓线不可见
        renderer.setDrawBarOutline(false);
        //渐变色
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue,
                0.0F, 0.0F, new Color(0, 0, 64));
        renderer.setSeriesPaint(0, gradientpaint);
        //显示条目数字
        renderer.setBaseItemLabelsVisible(true);
        //设置条目标签生成器,在JFreeChart1.0.6之前可以通过renderer.setItemLabelGenerator
        //(CategoryItemLabelGenerator generator)方法实现，但是从版本1.0.6开始有下面方法代替
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        //设置条目标签显示的位置,outline表示在条目区域外,baseline_center表示基于基线且居中
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE1, TextAnchor.BASELINE_CENTER));

        //保存图片
        //ChartUtilities.saveChartAsJPEG(new File("d:/bar2.jpg"), chart, 1280, 960);
        /**************************************************************/
        ChartFrame frame = new ChartFrame(statisticsType.getDescription(), chart, true);
        frame.pack();
        frame.setVisible(true);
    }


}
