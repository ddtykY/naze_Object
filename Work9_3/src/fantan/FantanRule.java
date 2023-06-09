package fantan;

import trump.Card;
import trump.Hand;
import trump.Rule;
import trump.Table;

/*
 *  クラス名 :FantanTable
 *  概要     :七並べのルールを表すクラス
 *  作成者   :山川勇輝
 *  作成日   :2023.06.08
 */
public class FantanRule implements Rule {
	/*
	 * 関数名           :findCandidate
	 * メソッドの説明   :テーブルに置けるカードを探す.手札とテーブルから、テーブルに出しうるカードを探す。
	 * パラメータの説明 :hand　手札
	 *                   table　テーブル
	 * 返り値           :見つかったカードの組み合わせ.見つからなかった場合はnullを返す.複数見つかった場合は最初の1枚を返す
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.08
	 */
	public Card[] findCandidate(Hand hand, Table table){
		// 返すカードを格納する配列をnullで初期化する
		Card[] candidateCard = null;
		
		// 手札のカード枚数を取得する
		int numberOfHand = hand.getNumberOfCards();
		// テーブルに置かれているカードを取得する
		Card[][] tableCard = table.getCards();
		
		// 手札の枚数分テーブルに置かれているカードと手札のカードを比較する
		// 手札の枚数分繰り返す
		for(int countHand = 0; countHand < numberOfHand; countHand++) {
			// countHand番目のカードを取得する
			Card handCard = hand.lookCard(countHand);
			// handCardのスートを取得する
			int handSuit = handCard.getSuit();
			// handCardの数字を取得する
			int handNumber = handCard.getNumber();
			
			// handCardの前後にあたる数字を調べる
			// handNumberの前の値を格納する変数
			int frontNumber = handNumber;
			// もしhandNumberがカードの最小値なら
			if(handNumber == Card.CARD_MINIMUM_NUM) {
				//  frontNumberをカード値の最大値とする
				frontNumber = Card.CARD_NUM;
			// もし最小値でないなら
			} else {
				// frontNumber をデクリメントする
				frontNumber--;
			}
			
			// handNumberの後の値を格納する変数
			int backNumber = handNumber;
			// もしhandNumberがカードの最大値なら
			if(handNumber == Card.CARD_NUM) {
				//  backNumberをカード値の最小値とする
				backNumber = Card.CARD_MINIMUM_NUM;
			// もし最大値でないなら
			} else {
				// backNumber をインクリメントする
				backNumber++;
			}
			
			// 手持ちのカードとテーブルに置かれているカードを比較する
			// もし手持ちのカードとスートが同じでその前後の数字を持つカードがテーブルに存在するなら
			if((tableCard[handSuit-1][frontNumber-1] != null) 
					|| (tableCard[handSuit-1][backNumber-1] != null)) {
				// candidateCardを要素数1の配列とする
				candidateCard = new Card[1];
				// 返却する配列の一番初めの要素にpickCardで得られたカードの参照を代入する
				candidateCard[0] = hand.pickCard(countHand);
				// 手札とテーブルに置かれているカードを比較するループを抜ける
				break;
			}
		}
		
		// テーブルに置けるカードを返却する.見つからなかった場合はnullを返す.
		return candidateCard;
	}
}
