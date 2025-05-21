package org.yumi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeDrawer extends JPanel {
    private final int cubeSize = 50;
    private final int[][] cubeVertices = {
            {-cubeSize, -cubeSize, -cubeSize},
            {cubeSize, -cubeSize, -cubeSize},
            {cubeSize, cubeSize, -cubeSize},
            {-cubeSize, cubeSize, -cubeSize},
            {-cubeSize, -cubeSize, cubeSize},
            {cubeSize, -cubeSize, cubeSize},
            {cubeSize, cubeSize, cubeSize},
            {-cubeSize, cubeSize, cubeSize}
    };
    private final int[][] cubeEdges = {
            {0, 1}, {1, 2}, {2, 3}, {3, 0},
            {4, 5}, {5, 6}, {6, 7}, {7, 4},
            {0, 4}, {1, 5}, {2, 6}, {3, 7}
    };

    private final double angleY = Math.toRadians(45);
    private final double angleX = Math.toRadians(30);
    private final int sphereRadius = 50;
    private final List<double[]> spherePoints;
    private final double scale = 1.2;

    public ShapeDrawer() {
        setBackground(Color.WHITE);
        spherePoints = generateSpherePoints(20);
    }

    private List<double[]> generateSpherePoints(int resolution) {
        List<double[]> points = new ArrayList<>();
        for (int phiStep = 0; phiStep <= resolution; phiStep++) {
            double phi = Math.PI * phiStep / resolution;
            for (int thetaStep = 0; thetaStep <= resolution; thetaStep++) {
                double theta = 2 * Math.PI * thetaStep / resolution;
                double x = sphereRadius * Math.sin(phi) * Math.cos(theta);
                double y = sphereRadius * Math.sin(phi) * Math.sin(theta);
                double z = sphereRadius * Math.cos(phi);
                points.add(new double[]{x, y, z});
            }
        }
        return points;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        
        // 绘制正方体（左侧）
        drawCube(g2d, centerX - 200, centerY);
        
        // 绘制球体（右侧）
        drawSphere(g2d, centerX + 200, centerY);
    }

    private void drawCube(Graphics2D g, int offsetX, int offsetY) {
        g.setColor(Color.BLUE);
        for (int[] edge : cubeEdges) {
            int[] p1 = cubeVertices[edge[0]];
            int[] p2 = cubeVertices[edge[1]];
            
            double[] rotatedP1 = rotatePoint(p1[0], p1[1], p1[2]);
            double[] rotatedP2 = rotatePoint(p2[0], p2[1], p2[2]);
            
            drawScaledLine(g, 
                offsetX + rotatedP1[0] * scale,
                offsetY - rotatedP1[1] * scale,
                offsetX + rotatedP2[0] * scale,
                offsetY - rotatedP2[1] * scale
            );
        }
    }

    private void drawSphere(Graphics2D g, int offsetX, int offsetY) {
        g.setColor(Color.RED);
        int resolution = 20;
        
        // 绘制纬线
        for (int phiStep = 0; phiStep <= resolution; phiStep++) {
            for (int thetaStep = 0; thetaStep < resolution; thetaStep++) {
                int index = phiStep * (resolution + 1) + thetaStep;
                connectPoints(g, offsetX, offsetY, index, index + 1);
            }
        }
        
        // 绘制经线
        for (int thetaStep = 0; thetaStep <= resolution; thetaStep++) {
            for (int phiStep = 0; phiStep < resolution; phiStep++) {
                int index = phiStep * (resolution + 1) + thetaStep;
                connectPoints(g, offsetX, offsetY, index, index + resolution + 1);
            }
        }
    }

    private void connectPoints(Graphics2D g, int offsetX, int offsetY, int i1, int i2) {
        double[] p1 = spherePoints.get(i1);
        double[] p2 = spherePoints.get(i2);
        
        double[] rotatedP1 = rotatePoint(p1[0], p1[1], p1[2]);
        double[] rotatedP2 = rotatePoint(p2[0], p2[1], p2[2]);
        
        drawScaledLine(g,
            offsetX + rotatedP1[0] * scale,
            offsetY - rotatedP1[1] * scale,
            offsetX + rotatedP2[0] * scale,
            offsetY - rotatedP2[1] * scale
        );
    }

    private double[] rotatePoint(double x, double y, double z) {
        // 绕Y轴旋转
        double x1 = x * Math.cos(angleY) + z * Math.sin(angleY);
        double z1 = -x * Math.sin(angleY) + z * Math.cos(angleY);
        
        // 绕X轴旋转
        double y1 = y * Math.cos(angleX) - z1 * Math.sin(angleX);
        double z2 = y * Math.sin(angleX) + z1 * Math.cos(angleX);
        
        return new double[]{x1, y1, z2};
    }

    private void drawScaledLine(Graphics2D g, double x1, double y1, double x2, double y2) {
        g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new ShapeDrawer());
        frame.setVisible(true);
    }
}