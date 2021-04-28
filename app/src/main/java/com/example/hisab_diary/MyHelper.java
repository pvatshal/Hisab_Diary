package com.example.hisab_diary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyHelper extends SQLiteOpenHelper {

    private static final String dbname = "DATABASE_6";
    private static final int version = 1;
    private static final String TABLE_NAME = "Transac";
    private static final String COLUMN_ID = "_id";
    private static final String AMOUNT = "amount";
    private static final String TRANSACTION_TYPE = "transaction_type";
    private static final String TAG = "tag";
    private static final String DATE = "date";
    private static final String NOTE = "note";
    private static final String CREATED_AT = "created_at";
    private static final String PAYMENT = "payment";

    private static final String TABLE_NAME_1 = "Budget";
    private static final String COLUMN_ID_1 = "_id";
    private static final String AMOUNT_1 = "amount";
    private static final String CATEGORY_1 = "category";

    private static final String TABLE_NAME_2 = "Currency";
    private static final String COLUMN_ID_2 = "_id";
    private static final String COUNTRY_NAME = "name";
    private static final String CURRENCY = "currency";
    private static final String VALUE = "value";


    public Context context;

    public MyHelper(Context context) {
        super(context, dbname, null, version);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE_NAME +
                "( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AMOUNT + " REAL, " +
                TRANSACTION_TYPE + " TEXT, " +
                TAG + " TEXT, " +
                DATE + " TEXT, " +
                NOTE + " TEXT, " +
                CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                PAYMENT + " TEXT );";


        String sql1 = "CREATE TABLE " + TABLE_NAME_1 +
                "( " + COLUMN_ID_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AMOUNT_1 + " REAL, " +
                CATEGORY_1 + " TEXT );";

        String sql15 = "CREATE TABLE " + TABLE_NAME_2 +
                "( " + COLUMN_ID_2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COUNTRY_NAME + " TEXT, " +
                CURRENCY + " TEXT, " +
                VALUE + " REAL);";


        String sql16 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Albania Lek','Lek',0)";



        String sql18 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Argentina Peso','$',0)";


        String sql19 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Aruba Guilder','ƒ',0)";


        String sql20 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Australia Dollar','$',0)";


        String sql21 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Azerbaijan Manat','₼',0)";


        String sql22 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Bahamas Dollar','$',0)";


        String sql23 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Barbados Dollar','$',0)";


        String sql24 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Belarus Ruble','Br',0)";


        String sql25 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Belize Dollar','BZ$',0)";


        String sql26 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Bermuda Dollar','$',0)";

        String sql27 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Bolivia Bolíviano','$b',0)";

        String sql28 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Bosnia and Herzegovina Convertible Mark','KM',0)";


        String sql29 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Botswana Pula','P',0)";


        String sql30 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Bulgaria Lev','лв',0)";


        String sql31 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Brazil Real','R$',0)";


        String sql32 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Brunei Darussalam Dollar','$',0)";


        String sql33 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Cambodia Riel','៛',0)";


        String sql34 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Canada Dollar','$',0)";


        String sql35 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Cayman Islands Dollar','$',0)";


        String sql36 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Chile Peso','$',0)";


        String sql37 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('China Yuan Renminbi','¥',0)";


        String sql38 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Colombia Peso','$',0)";


        String sql39 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Costa Rica Colon','₡',0)";


        String sql40 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Croatia Kuna','kn',0)";


        String sql41 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Cuba Peso','₱',0)";


        String sql42 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Czech Republic Koruna','Kč',0)";


        String sql43 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Denmark Krone','kr',0)";


        String sql44 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Dominican Republic Peso','RD$',0)";


        String sql45 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('East Caribbean Dollar','$',0)";


        String sql46 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Egypt Pound','£',0)";


        String sql47 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('El Salvador Colon','$',0)";


        String sql48 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Euro Member Countries','€',0)";


        String sql49 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Falkland Islands (Malvinas) Pound','£',0)";


        String sql50 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Fiji Dollar','$',0)";


        String sql51 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Ghana Cedi','¢',0)";


        String sql52 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Gibraltar Pound','£',0)";


        String sql53 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Guatemala Quetzal','Q',0)";


        String sql54 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Guernsey Pound','£',0)";


        String sql55 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Guyana Dollar','$',0)";


        String sql56 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Honduras Lempira','L',0)";


        String sql57 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Hong Kong Dollar','$',0)";


        String sql58 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Hungary Forint','Ft',0)";


        String sql59 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Iceland Krona','Kr',0)";


        String sql60 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('India Rupee','₹',1)";


        String sql61 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Indonesia Rupiah','Rp',0)";




        String sql63 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Isle of Man Pound','£',0)";


        String sql64 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Israel Shekel','₪',0)";


        String sql65 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Jamaica Dollar','J$',0)";


        String sql66 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Japan Yen','¥',0)";


        String sql67 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Jersey Pound','£',0)";


        String sql68 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Kazakhstan Tenge','лв',0)";


        String sql69 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Korea (North) Won','₩',0)";


        String sql70 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Korea (South) Won','₩',0)";


        String sql71 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Kyrgyzstan Som','лв',0)";


        String sql72 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Laos Kip','₭',0)";


        String sql73 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Lebanon Pound','£',0)";


        String sql74 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Liberia Dollar','$',0)";


        String sql75 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Macedonia Denar','ден',0)";


        String sql76 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Malaysia Ringgit','RM',0)";


        String sql77 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Mauritius Rupee','Rs',0)";


        String sql78 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Mexico Peso','$',0)";


        String sql79 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Mongolia Tughrik','₮',0)";


        String sql80 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Mozambique Metical','MT',0)";


        String sql81 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Namibia Dollar','$',0)";


        String sql82 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Nepal Rupee','Rs',0)";


        String sql83 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Netherlands Antilles Guilder','ƒ',0)";


        String sql120 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Zimbabwe Dollar','Z$',0)";
        String sql119 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Viet Nam Dong','₫',0)";
        String sql118 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Venezuela Bolívar','Bs',0)";
        String sql117 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Uzbekistan Som','лв',0)";
        String sql116 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Uruguay Peso','$U',0)";
        String sql115 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('United States Dollar','$',0)";
        String sql114 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('United Kingdom Pound','£',0)";
        String sql113 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Ukraine Hryvnia','₴',0)";
        String sql112 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Tuvalu Dollar','$',0)";
        String sql111 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Trinidad and Tobago Dollar','TT$',0)";
        String sql110 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Thailand Baht','฿',0)";
        String sql109 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Taiwan New Dollar','NT$',0)";
        String sql108 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Syria Pound','£',0)";
        String sql107 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Suriname Dollar','$',0)";
        String sql106 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Switzerland Franc','CHF',0)";
        String sql105 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Sweden Krona','kr',0)";
        String sql104 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Sri Lanka Rupee','Rs',0)";
        String sql103 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('South Africa Rand','R',0)";
        String sql102 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Somalia Shilling','S',0)";
        String sql101 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Solomon Islands Dollar','$',0)";
        String sql100 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Singapore Dollar','$',0)";
        String sql99 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Seychelles Rupee','Rs',0)";
        String sql98 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Serbia Dinar','Дин.',0)";
        String sql97 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Saint Helena Pound','£',0)";
        String sql96 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Russia Ruble','₽',0)";
        String sql95 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Romania Leu','lei',0)";
        String sql94 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Qatar Riyal','Rs',0)";
        String sql93 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Poland Zloty','zł',0)";
        String sql92 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Philippines Peso','₱',0)";
        String sql91 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Peru Sol','S/.',0)";
        String sql90 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Paraguay Guarani','Gs',0)";
        String sql89 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Panama Balboa','B/.',0)";
        String sql88 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Pakistan Rupee','Rs',0)";
        String sql87 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Norway Krone','kr',0)";
        String sql86 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Nigeria Naira','₦',0)";
        String sql85 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('Nicaragua Cordoba','C$',0)";
        String sql84 = "INSERT INTO " + TABLE_NAME_2 +
                " ( " + COUNTRY_NAME + ", " + CURRENCY + ", " + VALUE + " ) VALUES ('New Zealand Dollar','$',0)";

        String sql2 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Others')";
        String sql3 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Food')";
        String sql4 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Shopping')";
        String sql5 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Travelling')";
        String sql6 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Entertainment')";
        String sql7 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Medical')";
        String sql8 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Personal Care')";
        String sql9 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Education')";
        String sql10 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Bills')";
        String sql11 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Investments')";
        String sql12 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Rent')";
        String sql13 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Taxes')";
        String sql14 = "INSERT INTO " + TABLE_NAME_1 +
                " ( " + AMOUNT_1 + ", " + CATEGORY_1 + " ) VALUES (0,'Gifts & Donation')";


        db.execSQL(sql);
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
        db.execSQL(sql9);
        db.execSQL(sql10);
        db.execSQL(sql11);
        db.execSQL(sql12);
        db.execSQL(sql13);
        db.execSQL(sql14);
        db.execSQL(sql15);
        db.execSQL(sql16);
     //   db.execSQL(sql17);
        db.execSQL(sql18);
        db.execSQL(sql19);
        db.execSQL(sql20);
        db.execSQL(sql21);
        db.execSQL(sql22);
        db.execSQL(sql23);
        db.execSQL(sql24);
        db.execSQL(sql25);
        db.execSQL(sql26);
        db.execSQL(sql27);
        db.execSQL(sql28);
        db.execSQL(sql29);
        db.execSQL(sql30);
        db.execSQL(sql31);
        db.execSQL(sql32);
        db.execSQL(sql33);
        db.execSQL(sql34);
        db.execSQL(sql35);
        db.execSQL(sql36);
        db.execSQL(sql37);
        db.execSQL(sql38);
        db.execSQL(sql39);
        db.execSQL(sql40);
        db.execSQL(sql41);
        db.execSQL(sql42);
        db.execSQL(sql43);
        db.execSQL(sql44);
        db.execSQL(sql45);
        db.execSQL(sql46);
        db.execSQL(sql47);
        db.execSQL(sql48);
        db.execSQL(sql49);
        db.execSQL(sql50);
        db.execSQL(sql51);
        db.execSQL(sql52);
        db.execSQL(sql53);
        db.execSQL(sql54);
        db.execSQL(sql55);
        db.execSQL(sql56);
        db.execSQL(sql57);
        db.execSQL(sql58);
        db.execSQL(sql59);
        db.execSQL(sql60);
        db.execSQL(sql61);
    //    db.execSQL(sql62);
        db.execSQL(sql63);
        db.execSQL(sql64);
        db.execSQL(sql65);
        db.execSQL(sql66);
        db.execSQL(sql67);
        db.execSQL(sql68);
        db.execSQL(sql69);
        db.execSQL(sql70);
        db.execSQL(sql71);
        db.execSQL(sql72);
        db.execSQL(sql73);
        db.execSQL(sql74);
        db.execSQL(sql75);
        db.execSQL(sql76);
        db.execSQL(sql77);
        db.execSQL(sql78);
        db.execSQL(sql79);
        db.execSQL(sql80);
        db.execSQL(sql81);
        db.execSQL(sql82);
        db.execSQL(sql83);
        db.execSQL(sql84);
        db.execSQL(sql85);
        db.execSQL(sql86);
        db.execSQL(sql87);
        db.execSQL(sql88);
        db.execSQL(sql89);
        db.execSQL(sql90);
        db.execSQL(sql91);
        db.execSQL(sql92);
        db.execSQL(sql93);
        db.execSQL(sql94);
        db.execSQL(sql95);
        db.execSQL(sql96);
        db.execSQL(sql97);
        db.execSQL(sql98);
        db.execSQL(sql99);
        db.execSQL(sql100);
        db.execSQL(sql101);
        db.execSQL(sql102);
        db.execSQL(sql103);
        db.execSQL(sql104);
        db.execSQL(sql105);
        db.execSQL(sql106);
        db.execSQL(sql107);
        db.execSQL(sql108);
        db.execSQL(sql109);
        db.execSQL(sql110);
        db.execSQL(sql111);
        db.execSQL(sql112);
        db.execSQL(sql113);
        db.execSQL(sql114);
        db.execSQL(sql114);
        db.execSQL(sql115);
        db.execSQL(sql116);
        db.execSQL(sql117);
        db.execSQL(sql118);
        db.execSQL(sql119);
        db.execSQL(sql120);

        // insertData("Titan",34,"Expanse","food","34/23/4423","Notes of ml","334d33e","Case");

    }

    public void insertData(double amount, String transaction_type, String tag, String date, String note, String created_at, String payment) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("AMOUNT", amount);
        values.put("TRANSACTION_TYPE", transaction_type);
        values.put("TAG", tag);
        values.put("DATE", date);
        values.put("NOTE", note);
        values.put("CREATED_AT", created_at);
        values.put("PAYMENT", payment);

        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1) {
            Toast.makeText(context, "Falied To Add", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }

    }

//SELECT * FROM Transac WHERE date BETWEEN '09-02-2021' AND '11-02-2021'
    //SELECT * FROM Transac ORDER BY _id DESC LIMIT 3;

    Cursor readAllData() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            String query = "SELECT * FROM " + TABLE_NAME;
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllData_Currency() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            String query = "SELECT * FROM " + TABLE_NAME_2 + " ";
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    Cursor readAllData_week(String date1, String date2) {
        SQLiteDatabase db = this.getReadableDatabase();

        String d1 = "'" + date1 + "'";
        String d2 = "'" + date2 + "'";

        Cursor cursor = null;
        if (db != null) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + DATE + " BETWEEN " + d1 + " AND " + d2;
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    public float sumTheExpenseWeek(String date1, String date2) {
        float expense = 0;

        String str = "Expense";
        String d1 = "'" + date1 + "'";
        String d2 = "'" + date2 + "'";

        String sql = "SELECT SUM(AMOUNT) FROM " + TABLE_NAME + " WHERE " + DATE + " BETWEEN " + d1 + " AND " + d2 + " GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE='Expense')";

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            expense = cursor.getFloat(0);

        }
        return expense;
    }

    public float sumTheIncomeWeek(String date1, String date2) {
        float income = 0;

        String str = "Income";
        String d1 = "'" + date1 + "'";
        String d2 = "'" + date2 + "'";

        String sql = "SELECT SUM(AMOUNT) FROM " + TABLE_NAME + " WHERE " + DATE + " BETWEEN " + d1 + " AND " + d2 + " GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE='Income')";

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            income = cursor.getFloat(0);

        }
        return income;
    }


    Cursor readAllData_3_rows() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COLUMN_ID + " DESC LIMIT 3";
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    Cursor readAllData_1() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            String query = "SELECT * FROM " + TABLE_NAME_1;
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    public float sumTheExpense() {
        float expense = 0;

        String str = "Expense";

        String sql = "SELECT SUM(AMOUNT) FROM " + TABLE_NAME + " GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE='Expense')";

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            expense = cursor.getFloat(0);

        }
        return expense;
    }

    public float sumTheIncome() {
        float income = 0;

        String str = "Expense";

        String sql = "SELECT SUM(AMOUNT) FROM " + TABLE_NAME + " GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE='Income')";

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            income = cursor.getFloat(0);

        }
        return income;
    }

    public void Set_Value_To_1(String name) {
        String str = "'" + name + "'";

        String sql = "UPDATE " + TABLE_NAME_2 + " SET " + VALUE + " = 0 WHERE " + COUNTRY_NAME + " IS NOT " + str;
        String sql1 = "UPDATE " + TABLE_NAME_2 + " SET " + VALUE + " = 1 WHERE " + COUNTRY_NAME + " IS " + str;

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(sql);
        db.execSQL(sql1);
    }
    public int get_id_of_current_currency() {
        //String str = "'" + name + "'";

        String sql = "SELECT " + COLUMN_ID_2 + " FROM " + TABLE_NAME_2 + " WHERE "  + VALUE + " = 1";
        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")
        int amount=0;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            amount = cursor.getInt(0);
        }
        return (amount-1);
    }


    public String GetCurrency() {
        String amount = null;

        String sql = "SELECT " + CURRENCY + " FROM " + TABLE_NAME_2 + " WHERE " + VALUE + " = 1";

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            amount = cursor.getString(0);
        }
        return amount;
    }





    public double food_c(String tag) {
        double amount = 0;
        String str = "'" + tag + "'";

        String sql = "SELECT SUM(AMOUNT) FROM " + TABLE_NAME + " WHERE TAG = " + str;

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            amount = cursor.getFloat(0);

        }

        return amount;
    }

    public double food_p(String tag) {
        double amount = 0;
        String str = "'" + tag + "'";

        String sql = "SELECT SUM(AMOUNT) FROM " + TABLE_NAME + " WHERE PAYMENT = " + str;

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            amount = cursor.getFloat(0);
        }

        return amount;
    }

    public double total_budget() {
        double amount = 0;

        String sql = "SELECT SUM(AMOUNT) FROM " + TABLE_NAME_1 ;

        // SELECT  SUM(AMOUNT)  FROM  TRANSAC GROUP BY(TRANSACTION_TYPE) HAVING(TRANSACTION_TYPE="Expanse")

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            //   cursor.moveToNext();
            amount = cursor.getFloat(0);
        }
        return amount;
    }

    void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});

        if (result == -1) {
            Toast.makeText(context, "Falied To Delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
        onCreate(db);
    }

    public void updateData(String row_id, double amount, String transaction_type, String tag, String date, String note, String created_at, String payment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("AMOUNT", amount);
        values.put("TRANSACTION_TYPE", transaction_type);
        values.put("TAG", tag);
        values.put("DATE", date);
        values.put("NOTE", note);
        values.put("CREATED_AT", created_at);
        values.put("PAYMENT", payment);

        long result = db.update(TABLE_NAME, values, "_id=?", new String[]{row_id});

        if (result == -1) {
            Toast.makeText(context, "Falied To Update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
        }

    }

    public void updateData_1(String row_id, double amount, String tag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("AMOUNT", amount);
        values.put("CATEGORY", tag);

        long result = db.update(TABLE_NAME_1, values, "_id=?", new String[]{row_id});

        if (result == -1) {
            // Toast.makeText(context, "Falied To Update", Toast.LENGTH_SHORT).show();
        } else {
            // Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
        }

    }


    Cursor readCategorData(String category) {
        SQLiteDatabase db = this.getReadableDatabase();

        String cate = "'" + category + "'";
        Cursor cursor = null;
        if (db != null) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE TAG = " + cate;
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


}
