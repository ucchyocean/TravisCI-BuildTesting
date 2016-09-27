/*
 * @author     ucchy
 * @license    LGPLv3
 * @copyright  Copyright ucchy 2014
 */
package com.github.ucchyocean.lc.command;

import org.bukkit.command.CommandSender;

/**
 * dictionaryコマンドのエイリアス実行クラス、名前のみが異なるが、他は全て一緒。
 * @author ucchy
 */
public class DicCommand extends DictionaryCommand {

    private static final String COMMAND_NAME = "dic";
    private static final String USAGE_KEY = "usageDic";

    /**
     * コマンドを取得します。
     * @return コマンド
     * @see com.github.ucchyocean.lc.command.SubCommandAbst#getCommandName()
     */
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    /**
     * 使用方法に関するメッセージをsenderに送信します。
     * @param sender コマンド実行者
     * @param label 実行ラベル
     * @see com.github.ucchyocean.lc.command.SubCommandAbst#sendUsageMessage()
     */
    @Override
    public void sendUsageMessage(
            CommandSender sender, String label) {
        sendResourceMessage(sender, "", USAGE_KEY, label);
    }
}
