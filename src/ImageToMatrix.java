import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageToMatrix {
	public static void main(String[] args) throws IOException {
		File file = new File("/home/klann/robotica_final/furb_monocromatico_70x30.png");
		int contrast = 230;
		if(file.canRead()){
			BufferedImage img = ImageIO.read(file);
			int[][] matrix = new int[img.getWidth()][img.getHeight()];
			int rgb;
			int r;
			int g;
			int b;
			int value = 0;
			System.out.println("{");
			for(int y = 0; y < img.getHeight(); y++){
				System.out.print("{");
				for(int x = 0; x < img.getWidth(); x++){
					if(x>0) System.out.print(",");
					
					rgb = img.getRGB(x, y);
					r = (rgb >> 16) & 0xFF;
					g = (rgb >> 8) & 0xFF;
					b = rgb & 0xFF;
					
					if(	r > contrast && 
						g > contrast && 
						b > contrast){
						value = 0;
					} else {
						value = 1;
					}
					
					matrix[x][y] = value;
					System.out.print(value);
					
				}
				System.out.println("},");
			}
			System.out.println("}");
			
			//System.out.println(matrix);
			
		} else {
			System.out.println("O arquivo não pode ser lido.");
		}
	}

}
