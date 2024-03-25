package other;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestImageResize {

    public static void main(String[] args) {
        new TestImageResize();
    }

    public TestImageResize() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ScalePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ScalePane extends JPanel {

        private BufferedImage original;
        private BufferedImage scaled;

        public ScalePane() {
            try {
                original = ImageIO.read(new File("C:/Users/natha/Downloads/Untitled.jpg"));
                scaled = getScaledInstanceToFit(original, new Dimension(60, 60));
                ImageIO.write(scaled, "jpg", new File("scalemd.jpg"));

                BufferedImage image = new BufferedImage(52, 60, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(original, 0, 0, 52, 60, this);
                g2d.dispose();

                ImageIO.write(image, "jpg", new File("test.jpg"));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {

            Dimension size = super.getPreferredSize();
            if (original != null) {
                if (scaled != null) {
                    size.width = original.getWidth() + scaled.getWidth();
                    size.height = original.getHeight();
                } else {
                    size.width = original.getWidth();
                    size.height = original.getHeight();
                }
            }

            return size;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (original != null) {
                int x = 0;
                int y = (getHeight() - original.getHeight()) / 2;;
                if (scaled != null) {
                    x = (getWidth() - (original.getWidth() + scaled.getWidth())) / 2;
                } else {
                    x = (getWidth() - original.getWidth()) / 2;
                }
                g2d.drawImage(original, x, y, this);

                if (scaled != null) {
                    x += original.getWidth();
                    y = (getHeight() - scaled.getHeight()) / 2;
                    g2d.drawImage(scaled, x, y, this);
                }
            }
            g2d.dispose();
        }

        public BufferedImage getScaledInstanceToFit(BufferedImage img, Dimension size) {
            float scaleFactor = getScaleFactorToFit(img, size);
            return getScaledInstance(img, scaleFactor);
        }

        public float getScaleFactorToFit(BufferedImage img, Dimension size) {
            float scale = 1f;
            if (img != null) {
                int imageWidth = img.getWidth();
                int imageHeight = img.getHeight();
                scale = getScaleFactorToFit(new Dimension(imageWidth, imageHeight), size);
            }
            return scale;
        }

        public float getScaleFactorToFit(Dimension original, Dimension toFit) {
            float scale = 1f;
            if (original != null && toFit != null) {
                float dScaleWidth = getScaleFactor(original.width, toFit.width);
                float dScaleHeight = getScaleFactor(original.height, toFit.height);
                scale = Math.min(dScaleHeight, dScaleWidth);
            }
            return scale;
        }

        public float getScaleFactor(int iMasterSize, int iTargetSize) {
            float scale = 1;
            if (iMasterSize > iTargetSize) {
                scale = (float) iTargetSize / (float) iMasterSize;
            } else {
                scale = (float) iTargetSize / (float) iMasterSize;
            }
            return scale;
        }

        public BufferedImage getScaledInstance(BufferedImage img, double dScaleFactor) {
            BufferedImage imgBuffer = null;
            imgBuffer = getScaledInstance(img, dScaleFactor, RenderingHints.VALUE_INTERPOLATION_BILINEAR, true);
            return imgBuffer;
        }

        protected BufferedImage getScaledInstance(BufferedImage img, double dScaleFactor, Object hint, boolean higherQuality) {

            int targetWidth = (int) Math.round(img.getWidth() * dScaleFactor);
            int targetHeight = (int) Math.round(img.getHeight() * dScaleFactor);

            int type = (img.getTransparency() == Transparency.OPAQUE)
                            ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;

            BufferedImage ret = (BufferedImage) img;

            if (targetHeight > 0 || targetWidth > 0) {
                int w, h;
                if (higherQuality) {
                    w = img.getWidth();
                    h = img.getHeight();
                } else {
                    w = targetWidth;
                    h = targetHeight;
                }

                do {
                    if (higherQuality && w > targetWidth) {
                        w /= 2;
                        if (w < targetWidth) {
                            w = targetWidth;
                        }
                    }

                    if (higherQuality && h > targetHeight) {
                        h /= 2;
                        if (h < targetHeight) {
                            h = targetHeight;
                        }
                    }

                    BufferedImage tmp = new BufferedImage(Math.max(w, 1), Math.max(h, 1), type);
                    Graphics2D g2 = tmp.createGraphics();
                    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
                    g2.drawImage(ret, 0, 0, w, h, null);
                    g2.dispose();

                    ret = tmp;
                } while (w != targetWidth || h != targetHeight);
            } else {
                ret = new BufferedImage(1, 1, type);
            }
            return ret;
        }
    }
}