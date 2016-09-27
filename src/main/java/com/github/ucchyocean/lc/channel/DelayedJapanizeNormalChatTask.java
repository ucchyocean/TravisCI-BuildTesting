/*
 * @author     ucchy
 * @license    LGPLv3
 * @copyright  Copyright ucchy 2015
 */
package com.github.ucchyocean.lc.channel;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.github.ucchyocean.lc.LunaChat;
import com.github.ucchyocean.lc.japanize.JapanizeType;

/**
 * Japanize2行表示のときに、変換結果を遅延して通常チャットに表示するためのタスク
 * @author ucchy
 */
public class DelayedJapanizeNormalChatTask extends DelayedJapanizeConvertTask {

    private ChannelPlayer player;
    private AsyncPlayerChatEvent event;

    /**
     * コンストラクタ
     * @param org 変換前の文字列
     * @param type 変換タイプ
     * @param player 発言したプレイヤー
     * @param japanizeFormat 変換後に発言するときの、発言フォーマット
     * @param event イベント
     */
    public DelayedJapanizeNormalChatTask(String org, JapanizeType type,
            ChannelPlayer player, String japanizeFormat, final AsyncPlayerChatEvent event) {
        super(org, type, null, player, japanizeFormat);
        this.player = player;
        this.event = event;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        if ( runSync() ) {

            String result = getResult();

            // 送信
            for ( Player p : event.getRecipients() ) {
                p.sendMessage(result);
            }
            Bukkit.getConsoleSender().sendMessage(result);

            // 設定に応じてdynmapへ送信する
            if ( LunaChat.getInstance().getLunaChatConfig().
                    isSendBroadcastChannelChatToDynmap() &&
                    LunaChat.getInstance().getDynmap() != null ) {
                if ( player != null && player.getPlayer() != null )
                    LunaChat.getInstance().getDynmap().chat(player.getPlayer(), result);
                else
                    LunaChat.getInstance().getDynmap().broadcast(result);
            }
        }
    }
}
