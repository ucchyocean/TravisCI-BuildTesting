/*
 * @author     ucchy
 * @license    LGPLv3
 * @copyright  Copyright ucchy 2014
 */
package com.github.ucchyocean.lc;

import org.bukkit.scheduler.BukkitRunnable;

import com.github.ucchyocean.lc.channel.Channel;

/**
 * 各チャンネルの期限付きBANや期限付きMuteを、1分間隔で確認しに行くタスク
 * @author ucchy
 */
public class ExpireCheckTask extends BukkitRunnable {

    /**
     * 1分ごとに呼び出されるメソッド
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for ( Channel channel :
                LunaChat.getInstance().getLunaChatAPI().getChannels() ) {
            channel.checkExpires();
        }
    }
}
