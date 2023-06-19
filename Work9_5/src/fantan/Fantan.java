package fantan;

import trump.Card;
import trump.Hand;

/*
 *  クラス名 :Fantan
 *  概要     :七並べプログラム
 *  作成者   :山川勇輝
 *  作成日   :2023.06.09
 */
public class Fantan {
	/*
	 * 関数名           :main
	 * メソッドの説明   :七並べを行う
	 * パラメータの説明 :なし
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public static void main(String args[]) {
		// 進行役の生成
		// Work9-5 ------①
		FantanMaster fantanMaster = new FantanMaster();
		
		// テーブルの生成
		// Work9-5 ------②
		FantanTable fantanTable = new FantanTable();
		
		// ルールの生成
		// Work9-5 ------③
		FantanRule fantanRule = new FantanRule();
		
		// プレイヤーの生成
		// Work9-5 ------④
		// 村田さん
		FantanPlayer murataPlayer = new FantanPlayer("村田", fantanMaster, fantanTable, fantanRule);
		// 山田さん
		FantanPlayer yamadaPlayer = new FantanPlayer("山田", fantanMaster, fantanTable, fantanRule);
		// 斎藤さん
		FantanPlayer saitoPlayer = new FantanPlayer("斎藤", fantanMaster, fantanTable, fantanRule);
		
		// 進行役へプレイヤーを登録
		// Work9-5 ------⑤
		// 村田さん
		fantanMaster.registerPlayer(murataPlayer);
		// 山田さん
		fantanMaster.registerPlayer(yamadaPlayer);
		// 斎藤さん
		fantanMaster.registerPlayer(saitoPlayer);
		
		// トランプを生成する
		// Work9-5 ------⑥
		Hand trumpDeck = createTrump();
		
		// ゲームの準備をする
		// Work9-5 ------⑦
		fantanMaster.prepareGame(trumpDeck);
		
		// ゲームを開始する
		// Work9-5 ------⑧
		fantanMaster.startGame();
		
	}
	
	/*
	 * 関数名           :createTrump
	 * メソッドの説明   :52枚のトランプを生成する
	 * パラメータの説明 :なし
	 * 返り値           :トランプを格納したDeal
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public static Hand createTrump() {
		// 手札のインスタンスを生成
		Hand trumpDeck = new Hand();
		
		// 各スート52枚のカードを生成する
		// トランプの数字の種類分繰り返す
		for(int number = Card.CARD_MINIMUM_NUM; number <= Card.CARD_NUM; number++) {
			// クローバーのカードを加える
			trumpDeck.addCard(new Card(Card.SUIT_CLUB, number));
			// ダイヤのカードを加える
			trumpDeck.addCard(new Card(Card.SUIT_DIAMOND, number));
			// ハートのカードを加える
			trumpDeck.addCard(new Card(Card.SUIT_HEART, number));
			// スペードのカードを加える
			trumpDeck.addCard(new Card(Card.SUIT_SPADE, number));
		}
		
		// 手札として一つのインスタンスにまとめたトランプの束を返却する
		return trumpDeck;
	}
	
}
