package com.dais.utils;

import java.util.Random;

/**
 * @author xxp
 * @version 2018- 01- 26 22:28
 * @description
 * @copyright www.zhgtrade.com
 */
public class MemWordsUtil {

    public static String MEM_WORDS = "decent,ralized,plat,form,that,runs,smart,cont,that,run,exactly,as,prog,rammed,without,any," +
            "possi,bility,of,downtime,censor,ship,fraud,or,third," +
            "party,inter,ference,these,apps,run,on,custom,built,block,chain,an,power,ful,shared,global," +
            "that,can,move,value,around,and,repr,esent,the,owner,ship,of,pro,perty,thenables,deve,opers," +
            "to,create,market,store,of,debts,or,move,funds,in," +
            "acco,rdance,with,inst,given,long,in,the,past,like,will,or,futures,and,many,other,things," +
            "that,have,not,been,yet,all,without,or,risk," +
            "the,project,was,boot,vian,ether,presale,in,august,by,fans,all,around,the,world,it,deve," +
            "loped,by,the,foun,dation,swiss,non,profit,with," +
            "from,great,minds,across,the,globe,on,server,archit,ectures,every,appli,cation,has,to,set,up,its," +
            "own,servers,that,run,their,own,code,in,isolated,silos,making,sharing,of,dathard,if,single," +
            "app,or,goes,offline,many,users,and,other,apps,are,affected," +
            "on,anyone,can,set,up,node,that,the,nece,ssary,datfor,all,nodes,to,reach,an,and,be,by,users,and,app,thallows," +
            "user,datto,remain,private,and,apps,to,be,like,the,internet,was,sup,posed,to,work";

    public static String createMemWords() {
        String[] arr = MEM_WORDS.split(",");
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int pos = random.nextInt(arr.length);
            result = result + arr[pos]+",";
        }
        return result.substring(0,result.length()-1).replaceAll(" +","");
    }

    public static void main(String[] args) {
        System.out.println(createMemWords());
    }
}
