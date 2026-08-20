package HitAndBlow;

import java.util.Random;
import java.util.Scanner;

public class HitAndBlow {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		while (true) {

			// ランダムな3桁の数字を生成
			// 1桁目が0にならないようにdo-while文を追加
			String answer;

			do {
				answer = String.format("%03d", random.nextInt(1000));
			}while(answer.charAt(0) == 0);



			boolean clear = false;

			// 最大10回挑戦
			for (int count = 1; count <= 10; count++) {

				String input;

				// 入力チェック
				while (true) {
					System.out.println("3桁の数字を入力してください。");
					input = scanner.nextLine();

					if (input.matches("\\d{3}")) {
						break;
					}

					System.out.println("3桁の数字を入力してください。");
				}

				int hit = 0;
				int blow = 0;

				// ヒット・ブロー判定
				for (int i = 0; i < 3; i++) {

					// ブロー時の条件を入れ替えた
					if (answer.charAt(i) == input.charAt(i)) {
						hit++;
					} else {
						for (int j = 0; j < 3; j++) {
							if (i != j && answer.charAt(i) == input.charAt(j)) {
								blow++;
								break;
							}
						}
					}
				}

				System.out.println(hit + "ヒット、" + blow + "ブロー");
				
				// 表示文の「3ヒット」がくどかったので削除
				if (hit == 3) {
					System.out.println("正解です。");
					clear = true;
					break;
				}
			}

			if (!clear) {
				System.out.println("正解は、" + answer + "でした。");
			}

			// もう一度遊ぶか確認
			while (true) {
				System.out.println("もう一度ゲームをしますか？　0:はい　1:いいえ");
				String select = scanner.nextLine();

				if ("0".equals(select)) {
					// 仕様に従う
					break;
				} else if ("1".equals(select)) {
					System.out.println("ゲームを終了します。");
					scanner.close();
					return;
				} else {
					System.out.println("0または1を入力してください。");
				}
			}
		}
	}
}