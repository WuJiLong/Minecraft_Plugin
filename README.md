# Minecraft_Plugin
Minecraft版本：1.15  
自我練習用專案  
  
## 指令列表:  
getitem 取得自定義道具  
itemlist 以GUI顯示道具列表  
opengui 開啟平板電腦主畫面  
  
## 道具列表:  

### Adventure
InfiniteFireworks 火箭推進器  
Hardener 固化劑  
Elytra 強化鞘翅  
### Excalibur
Excalibur 斷剛聖劍  
Strengthengold_ingot 強化金錠  
Strengthengold_block 強化金磚  
Gilded_diamond 鍍金鑽  
Gildedgrip 神器握把  
God_of_pickaxe 斷剛神稿  
God_of_axe 斷剛神斧  
### Other
I_pad 平板電腦  
  
##  目前功能：
保護玩家 避免一次性受到大量傷害導致裝備耐久gg (src\wuchilong\mc\plugin\OtherListener.java)  
GUI顯示道具列表以及合成表 (src\wuchilong\mc\plugin\GUI\GUIlist\GUI_itemRecipe.java)  
自定義合成表  (src\wuchilong\mc\plugin\item\CustomItem.java)  
一次挖掘 NxNxN範圍方塊  (src\wuchilong\mc\plugin\item\itemlist\Excalibur\ItemGod_of_pickaxe.java)  
快速砍樹(簡易版)  (src\wuchilong\mc\plugin\item\itemlist\Excalibur\ItemGod_of_axe.java)  
無限煙火  (src\wuchilong\mc\plugin\item\itemlist\Adventure\ItemInfiniteFireworks.java)  
根據玩家遊戲語言給予訊息  (src\wuchilong\mc\plugin\item\CustomItem.java onBlockPlaceEvent)  

