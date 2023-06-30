package oldMaid;

import trump.Card;
import trump.Hand;
import trump.Joker;
import trump.Master;

/*
 *  クラス名 :OldMaid
 *  概要     :ババ抜きプログラム
 *  作成者   :山川勇輝
 *  作成日   :2023.06.09
 */
public class OldMaid {
	/*
	 * 関数名           :main
	 * メソッドの説明   :ババ抜きを行う
	 * パラメータの説明 :なし
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public static void main(String args[]) {
		// 進行役を生成する
		Master master = new Master();
		
		// テーブルを生成する
		OldMaidTable oldMaidTable = new OldMaidTable();
		
		// ルールを生成する
		OldMaidRule oldMaidRule = new OldMaidRule();
		
		// プレイヤーを生成する
		// 村田さん
		OldMaidPlayer murataPlayer = new OldMaidPlayer("村田", master, oldMaidTable, oldMaidRule);
		// 山田さん
		OldMaidPlayer yamadaPlayer = new OldMaidPlayer("山田", master, oldMaidTable, oldMaidRule);
		// 斎藤さん
		OldMaidPlayer saitoPlayer = new OldMaidPlayer("斎藤", master, oldMaidTable, oldMaidRule);
		
		// 進行役に参加者を伝える
		// 村田さん
		master.registerPlayer(murataPlayer);
		// 山田さん
		master.registerPlayer(yamadaPlayer);
		// 斎藤さん
		master.registerPlayer(saitoPlayer);
		
		// トランプを生成する
		Hand trumpDeck = createTrump();
		
		// ゲームを準備する
		master.prepareGame(trumpDeck);
		
		// ゲームを開始する
		master.startGame();
		
	}
	
	/*
	 * 関数名           :createTrump
	 * メソッドの説明   :53枚のトランプを生成する
	 * パラメータの説明 :なし
	 * 返り値           :なし
	 * 作成者           :山川勇輝
	 * 作成日           :2023.06.09
	 */
	public static Hand createTrump() {
		// トランプの束
		Hand trumpDeck = new Hand();
		
		// カードの数字の種類だけ繰り返す
		for(int countNumber = Card.CARD_MINIMUM_NUM; countNumber <= Card.CARD_NUM; countNumber++) {
			// クラブのカードを生成しデッキに加える
			trumpDeck.addCard(new Card(Card.SUIT_CLUB, countNumber));
			// ダイヤのカードを生成しデッキに加える
			trumpDeck.addCard(new Card(Card.SUIT_DIAMOND, countNumber));
			// ハートのカードを生成しデッキに加える
			trumpDeck.addCard(new Card(Card.SUIT_HEART, countNumber));
			// スペードのカードを生成しデッキに加える
			trumpDeck.addCard(new Card(Card.SUIT_SPADE, countNumber));
		}
		// ジョーカーを生成しデッキに加える
		trumpDeck.addCard(new Joker());
		
		// trumpDeckを返却する
		return trumpDeck;
	}
}

