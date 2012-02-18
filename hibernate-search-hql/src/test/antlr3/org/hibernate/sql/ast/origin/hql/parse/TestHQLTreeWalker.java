// $ANTLR 3.3 Nov 30, 2010 12:46:29 /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g 2012-02-17 17:46:22

/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 *
 * Portions of SQL grammar parsing copyright (C) 2003 by Lubos Vnuk.  All rights
 * reserved.  These portions are distributed under license by Red Hat Middleware
 * LLC and are covered by the above LGPL notice.  If you redistribute this material,
 * with or without modification, you must preserve this copyright notice in its
 * entirety.
 */
package org.hibernate.sql.ast.phase.hql.parse;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class TestHQLTreeWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TABLE", "COLUMN", "COLUMN_LIST", "ALIAS_NAME", "ALIAS_REF", "BETWEEN_LIST", "COLLATE", "COLLECTION_EXPRESSION", "DOT_CLASS", "DYNAMIC_INSTANTIATION_ARG", "DYNAMIC_INSTANTIATION", "ENTITY_NAME", "ENTITY_PERSISTER_REF", "FILTER", "FUNCTION", "GROUPING_VALUE", "IN_LIST", "INSERTABILITY_SPEC", "IS_NOT_EMPTY", "IS_NOT_NULL", "IS_NULL", "JAVA_CONSTANT", "JPA_PARAM", "NAMED_PARAM", "NOT_BETWEEN", "NOT_IN", "NOT_LIKE", "NOT_MEMBER_OF", "ORDER_SPEC", "PATH", "PERSISTER_JOIN", "PERSISTER_SPACE", "PROP_FETCH", "PROPERTY_JOIN", "PROPERTY_REFERENCE", "QUALIFIED_JOIN", "QUERY_SPEC", "QUERY", "SEARCHED_CASE", "SELECT_FROM", "SELECT_ITEM", "SELECT_LIST", "SIMPLE_CASE", "SORT_SPEC", "SUB_QUERY", "UNARY_MINUS", "UNARY_PLUS", "VECTOR_EXPR", "VERSIONED_VALUE", "ABS", "ALL", "AND", "ANY", "AS", "AVG", "BETWEEN", "BIT_LENGTH", "BOTH", "CAST", "CHARACTER_LENGTH", "CLASS", "COALESCE", "CONCAT", "COUNT", "CROSS", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "DAY", "DELETE", "DISTINCT", "ELEMENTS", "ELSE", "END", "ESCAPE", "EXCEPT", "EXISTS", "EXTRACT", "FETCH", "FROM", "FULL", "GROUP_BY", "HAVING", "HOUR", "IN", "INDEX", "INDICES", "INNER", "INSERT", "INTERSECT", "INTO", "IS_EMPTY", "IS", "JOIN", "LEADING", "LEFT", "LENGTH", "LIKE", "LOCATE", "LOWER", "MAX", "MAXELEMENT", "MAXINDEX", "MEMBER_OF", "MIN", "MINELEMENT", "MININDEX", "MINUTE", "MOD", "MONTH", "NEW", "NOT", "NULLIF", "OCTET_LENGTH", "ON", "OR", "ORDER_BY", "OUTER", "POSITION", "PROPERTIES", "RIGHT", "SECOND", "SELECT", "SET", "SIZE", "SOME", "SQRT", "SUBSTRING", "SUM", "THEN", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TRAILING", "TRIM", "UNION", "UPDATE", "UPPER", "VERSIONED", "WHEN", "WHERE", "WITH", "YEAR", "EOL", "WS", "HEX_DIGIT", "INTEGER_TYPE_SUFFIX", "HEX_LITERAL", "INTEGER_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", "EXPONENT", "FLOAT_TYPE_SUFFIX", "FLOATING_POINT_LITERAL", "ESCAPE_SEQUENCE", "CHARACTER_LITERAL", "STRING_LITERAL", "UNICODE_ESCAPE", "OCTAL_ESCAPE", "TRUE", "FALSE", "NULL", "EQUALS", "SEMICOLON", "COLON", "NOT_EQUAL", "PIPE", "DOUBLE_PIPE", "PARAM", "GREATER", "GREATER_EQUAL", "LESS", "LESS_EQUAL", "ARROW", "IDENTIFIER", "QUOTED_IDENTIFIER", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_SQUARE", "RIGHT_SQUARE", "COMMA", "DOT", "PLUS", "MINUS", "ASTERISK", "SOLIDUS", "PERCENT", "AMPERSAND", "GENERAL_FUNCTION_CALL"
    };
    public static final int EOF=-1;
    public static final int TABLE=4;
    public static final int COLUMN=5;
    public static final int COLUMN_LIST=6;
    public static final int ALIAS_NAME=7;
    public static final int ALIAS_REF=8;
    public static final int BETWEEN_LIST=9;
    public static final int COLLATE=10;
    public static final int COLLECTION_EXPRESSION=11;
    public static final int DOT_CLASS=12;
    public static final int DYNAMIC_INSTANTIATION_ARG=13;
    public static final int DYNAMIC_INSTANTIATION=14;
    public static final int ENTITY_NAME=15;
    public static final int ENTITY_PERSISTER_REF=16;
    public static final int FILTER=17;
    public static final int FUNCTION=18;
    public static final int GROUPING_VALUE=19;
    public static final int IN_LIST=20;
    public static final int INSERTABILITY_SPEC=21;
    public static final int IS_NOT_EMPTY=22;
    public static final int IS_NOT_NULL=23;
    public static final int IS_NULL=24;
    public static final int JAVA_CONSTANT=25;
    public static final int JPA_PARAM=26;
    public static final int NAMED_PARAM=27;
    public static final int NOT_BETWEEN=28;
    public static final int NOT_IN=29;
    public static final int NOT_LIKE=30;
    public static final int NOT_MEMBER_OF=31;
    public static final int ORDER_SPEC=32;
    public static final int PATH=33;
    public static final int PERSISTER_JOIN=34;
    public static final int PERSISTER_SPACE=35;
    public static final int PROP_FETCH=36;
    public static final int PROPERTY_JOIN=37;
    public static final int PROPERTY_REFERENCE=38;
    public static final int QUALIFIED_JOIN=39;
    public static final int QUERY_SPEC=40;
    public static final int QUERY=41;
    public static final int SEARCHED_CASE=42;
    public static final int SELECT_FROM=43;
    public static final int SELECT_ITEM=44;
    public static final int SELECT_LIST=45;
    public static final int SIMPLE_CASE=46;
    public static final int SORT_SPEC=47;
    public static final int SUB_QUERY=48;
    public static final int UNARY_MINUS=49;
    public static final int UNARY_PLUS=50;
    public static final int VECTOR_EXPR=51;
    public static final int VERSIONED_VALUE=52;
    public static final int ABS=53;
    public static final int ALL=54;
    public static final int AND=55;
    public static final int ANY=56;
    public static final int AS=57;
    public static final int AVG=58;
    public static final int BETWEEN=59;
    public static final int BIT_LENGTH=60;
    public static final int BOTH=61;
    public static final int CAST=62;
    public static final int CHARACTER_LENGTH=63;
    public static final int CLASS=64;
    public static final int COALESCE=65;
    public static final int CONCAT=66;
    public static final int COUNT=67;
    public static final int CROSS=68;
    public static final int CURRENT_DATE=69;
    public static final int CURRENT_TIME=70;
    public static final int CURRENT_TIMESTAMP=71;
    public static final int DAY=72;
    public static final int DELETE=73;
    public static final int DISTINCT=74;
    public static final int ELEMENTS=75;
    public static final int ELSE=76;
    public static final int END=77;
    public static final int ESCAPE=78;
    public static final int EXCEPT=79;
    public static final int EXISTS=80;
    public static final int EXTRACT=81;
    public static final int FETCH=82;
    public static final int FROM=83;
    public static final int FULL=84;
    public static final int GROUP_BY=85;
    public static final int HAVING=86;
    public static final int HOUR=87;
    public static final int IN=88;
    public static final int INDEX=89;
    public static final int INDICES=90;
    public static final int INNER=91;
    public static final int INSERT=92;
    public static final int INTERSECT=93;
    public static final int INTO=94;
    public static final int IS_EMPTY=95;
    public static final int IS=96;
    public static final int JOIN=97;
    public static final int LEADING=98;
    public static final int LEFT=99;
    public static final int LENGTH=100;
    public static final int LIKE=101;
    public static final int LOCATE=102;
    public static final int LOWER=103;
    public static final int MAX=104;
    public static final int MAXELEMENT=105;
    public static final int MAXINDEX=106;
    public static final int MEMBER_OF=107;
    public static final int MIN=108;
    public static final int MINELEMENT=109;
    public static final int MININDEX=110;
    public static final int MINUTE=111;
    public static final int MOD=112;
    public static final int MONTH=113;
    public static final int NEW=114;
    public static final int NOT=115;
    public static final int NULLIF=116;
    public static final int OCTET_LENGTH=117;
    public static final int ON=118;
    public static final int OR=119;
    public static final int ORDER_BY=120;
    public static final int OUTER=121;
    public static final int POSITION=122;
    public static final int PROPERTIES=123;
    public static final int RIGHT=124;
    public static final int SECOND=125;
    public static final int SELECT=126;
    public static final int SET=127;
    public static final int SIZE=128;
    public static final int SOME=129;
    public static final int SQRT=130;
    public static final int SUBSTRING=131;
    public static final int SUM=132;
    public static final int THEN=133;
    public static final int TIMEZONE_HOUR=134;
    public static final int TIMEZONE_MINUTE=135;
    public static final int TRAILING=136;
    public static final int TRIM=137;
    public static final int UNION=138;
    public static final int UPDATE=139;
    public static final int UPPER=140;
    public static final int VERSIONED=141;
    public static final int WHEN=142;
    public static final int WHERE=143;
    public static final int WITH=144;
    public static final int YEAR=145;
    public static final int EOL=146;
    public static final int WS=147;
    public static final int HEX_DIGIT=148;
    public static final int INTEGER_TYPE_SUFFIX=149;
    public static final int HEX_LITERAL=150;
    public static final int INTEGER_LITERAL=151;
    public static final int DECIMAL_LITERAL=152;
    public static final int OCTAL_LITERAL=153;
    public static final int EXPONENT=154;
    public static final int FLOAT_TYPE_SUFFIX=155;
    public static final int FLOATING_POINT_LITERAL=156;
    public static final int ESCAPE_SEQUENCE=157;
    public static final int CHARACTER_LITERAL=158;
    public static final int STRING_LITERAL=159;
    public static final int UNICODE_ESCAPE=160;
    public static final int OCTAL_ESCAPE=161;
    public static final int TRUE=162;
    public static final int FALSE=163;
    public static final int NULL=164;
    public static final int EQUALS=165;
    public static final int SEMICOLON=166;
    public static final int COLON=167;
    public static final int NOT_EQUAL=168;
    public static final int PIPE=169;
    public static final int DOUBLE_PIPE=170;
    public static final int PARAM=171;
    public static final int GREATER=172;
    public static final int GREATER_EQUAL=173;
    public static final int LESS=174;
    public static final int LESS_EQUAL=175;
    public static final int ARROW=176;
    public static final int IDENTIFIER=177;
    public static final int QUOTED_IDENTIFIER=178;
    public static final int LEFT_PAREN=179;
    public static final int RIGHT_PAREN=180;
    public static final int LEFT_SQUARE=181;
    public static final int RIGHT_SQUARE=182;
    public static final int COMMA=183;
    public static final int DOT=184;
    public static final int PLUS=185;
    public static final int MINUS=186;
    public static final int ASTERISK=187;
    public static final int SOLIDUS=188;
    public static final int PERCENT=189;
    public static final int AMPERSAND=190;
    public static final int GENERAL_FUNCTION_CALL=191;

    // delegates
    // delegators


        public TestHQLTreeWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public TestHQLTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return TestHQLTreeWalker.tokenNames; }
    public String getGrammarFileName() { return "/home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g"; }


    public static class filterStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filterStatement"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:44:1: filterStatement[String collectionRole] : ^( QUERY ^( QUERY_SPEC FILTER ( selectClause )? ( whereClause )? ( groupByClause ( havingClause )? )? ( orderByClause )? ) ) ;
    public final TestHQLTreeWalker.filterStatement_return filterStatement(String collectionRole) throws RecognitionException {
        TestHQLTreeWalker.filterStatement_return retval = new TestHQLTreeWalker.filterStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        CommonTree QUERY_SPEC2=null;
        CommonTree FILTER3=null;
        TestHQLTreeWalker.selectClause_return selectClause4 = null;

        TestHQLTreeWalker.whereClause_return whereClause5 = null;

        TestHQLTreeWalker.groupByClause_return groupByClause6 = null;

        TestHQLTreeWalker.havingClause_return havingClause7 = null;

        TestHQLTreeWalker.orderByClause_return orderByClause8 = null;


        CommonTree QUERY1_tree=null;
        CommonTree QUERY_SPEC2_tree=null;
        CommonTree FILTER3_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:45:2: ( ^( QUERY ^( QUERY_SPEC FILTER ( selectClause )? ( whereClause )? ( groupByClause ( havingClause )? )? ( orderByClause )? ) ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:45:4: ^( QUERY ^( QUERY_SPEC FILTER ( selectClause )? ( whereClause )? ( groupByClause ( havingClause )? )? ( orderByClause )? ) )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_filterStatement56); 


            if ( _first_0==null ) _first_0 = QUERY1;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            _last = (CommonTree)input.LT(1);
            QUERY_SPEC2=(CommonTree)match(input,QUERY_SPEC,FOLLOW_QUERY_SPEC_in_filterStatement59); 


            if ( _first_1==null ) _first_1 = QUERY_SPEC2;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            FILTER3=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filterStatement61); 
             
            if ( _first_2==null ) _first_2 = FILTER3;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:5: ( selectClause )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==SELECT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:5: selectClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_selectClause_in_filterStatement68);
                    selectClause4=selectClause();

                    state._fsp--;

                     
                    if ( _first_2==null ) _first_2 = selectClause4.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }

            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:19: ( whereClause )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==WHERE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:19: whereClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_whereClause_in_filterStatement71);
                    whereClause5=whereClause();

                    state._fsp--;

                     
                    if ( _first_2==null ) _first_2 = whereClause5.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }

            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:32: ( groupByClause ( havingClause )? )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==GROUP_BY) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:34: groupByClause ( havingClause )?
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_groupByClause_in_filterStatement76);
                    groupByClause6=groupByClause();

                    state._fsp--;

                     
                    if ( _first_2==null ) _first_2 = groupByClause6.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:48: ( havingClause )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==HAVING) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:48: havingClause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_havingClause_in_filterStatement78);
                            havingClause7=havingClause();

                            state._fsp--;

                             
                            if ( _first_2==null ) _first_2 = havingClause7.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }

            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:64: ( orderByClause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==ORDER_BY) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:46:64: orderByClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_orderByClause_in_filterStatement83);
                    orderByClause8=orderByClause();

                    state._fsp--;

                     
                    if ( _first_2==null ) _first_2 = orderByClause8.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_2;
            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "filterStatement"

    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:49:1: statement : ( updateStatementSet | deleteStatementSet | insertStatementSet | queryStatementSet );
    public final TestHQLTreeWalker.statement_return statement() throws RecognitionException {
        TestHQLTreeWalker.statement_return retval = new TestHQLTreeWalker.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.updateStatementSet_return updateStatementSet9 = null;

        TestHQLTreeWalker.deleteStatementSet_return deleteStatementSet10 = null;

        TestHQLTreeWalker.insertStatementSet_return insertStatementSet11 = null;

        TestHQLTreeWalker.queryStatementSet_return queryStatementSet12 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:50:2: ( updateStatementSet | deleteStatementSet | insertStatementSet | queryStatementSet )
            int alt6=4;
            switch ( input.LA(1) ) {
            case UPDATE:
                {
                alt6=1;
                }
                break;
            case DELETE:
                {
                alt6=2;
                }
                break;
            case INSERT:
                {
                alt6=3;
                }
                break;
            case QUERY:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:50:4: updateStatementSet
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_updateStatementSet_in_statement97);
                    updateStatementSet9=updateStatementSet();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = updateStatementSet9.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:51:4: deleteStatementSet
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_deleteStatementSet_in_statement102);
                    deleteStatementSet10=deleteStatementSet();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = deleteStatementSet10.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:52:4: insertStatementSet
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_insertStatementSet_in_statement107);
                    insertStatementSet11=insertStatementSet();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = insertStatementSet11.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:53:4: queryStatementSet
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_queryStatementSet_in_statement112);
                    queryStatementSet12=queryStatementSet();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = queryStatementSet12.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class updateStatementSet_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateStatementSet"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:56:1: updateStatementSet : ( updateStatement )+ ;
    public final TestHQLTreeWalker.updateStatementSet_return updateStatementSet() throws RecognitionException {
        TestHQLTreeWalker.updateStatementSet_return retval = new TestHQLTreeWalker.updateStatementSet_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.updateStatement_return updateStatement13 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:57:2: ( ( updateStatement )+ )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:57:4: ( updateStatement )+
            {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:57:4: ( updateStatement )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==UPDATE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:57:4: updateStatement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_updateStatement_in_updateStatementSet123);
            	    updateStatement13=updateStatement();

            	    state._fsp--;

            	     
            	    if ( _first_0==null ) _first_0 = updateStatement13.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "updateStatementSet"

    public static class updateStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateStatement"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:60:1: updateStatement : ^( UPDATE entityName ^( SET ( assignment )+ ) ( whereClause )? ) ;
    public final TestHQLTreeWalker.updateStatement_return updateStatement() throws RecognitionException {
        TestHQLTreeWalker.updateStatement_return retval = new TestHQLTreeWalker.updateStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UPDATE14=null;
        CommonTree SET16=null;
        TestHQLTreeWalker.entityName_return entityName15 = null;

        TestHQLTreeWalker.assignment_return assignment17 = null;

        TestHQLTreeWalker.whereClause_return whereClause18 = null;


        CommonTree UPDATE14_tree=null;
        CommonTree SET16_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:61:2: ( ^( UPDATE entityName ^( SET ( assignment )+ ) ( whereClause )? ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:61:4: ^( UPDATE entityName ^( SET ( assignment )+ ) ( whereClause )? )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            UPDATE14=(CommonTree)match(input,UPDATE,FOLLOW_UPDATE_in_updateStatement136); 


            if ( _first_0==null ) _first_0 = UPDATE14;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_entityName_in_updateStatement138);
            entityName15=entityName();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = entityName15.tree;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            _last = (CommonTree)input.LT(1);
            SET16=(CommonTree)match(input,SET,FOLLOW_SET_in_updateStatement141); 


            if ( _first_1==null ) _first_1 = SET16;
            match(input, Token.DOWN, null); 
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:61:30: ( assignment )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==EQUALS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:61:30: assignment
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_assignment_in_updateStatement143);
            	    assignment17=assignment();

            	    state._fsp--;

            	     
            	    if ( _first_2==null ) _first_2 = assignment17.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            match(input, Token.UP, null); _last = _save_last_2;
            }

            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:61:43: ( whereClause )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==WHERE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:61:43: whereClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_whereClause_in_updateStatement147);
                    whereClause18=whereClause();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = whereClause18.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "updateStatement"

    public static class assignment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:64:1: assignment : ( ^( EQUALS propertyReference valueExpression ) | ^( EQUALS VERSIONED_VALUE STRING_LITERAL ) );
    public final TestHQLTreeWalker.assignment_return assignment() throws RecognitionException {
        TestHQLTreeWalker.assignment_return retval = new TestHQLTreeWalker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EQUALS19=null;
        CommonTree EQUALS22=null;
        CommonTree VERSIONED_VALUE23=null;
        CommonTree STRING_LITERAL24=null;
        TestHQLTreeWalker.propertyReference_return propertyReference20 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression21 = null;


        CommonTree EQUALS19_tree=null;
        CommonTree EQUALS22_tree=null;
        CommonTree VERSIONED_VALUE23_tree=null;
        CommonTree STRING_LITERAL24_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:65:2: ( ^( EQUALS propertyReference valueExpression ) | ^( EQUALS VERSIONED_VALUE STRING_LITERAL ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==EQUALS) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==DOWN) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==VERSIONED_VALUE) ) {
                        alt10=2;
                    }
                    else if ( (LA10_2==PROPERTY_REFERENCE) ) {
                        alt10=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:65:4: ^( EQUALS propertyReference valueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    EQUALS19=(CommonTree)match(input,EQUALS,FOLLOW_EQUALS_in_assignment161); 


                    if ( _first_0==null ) _first_0 = EQUALS19;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_propertyReference_in_assignment163);
                    propertyReference20=propertyReference();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = propertyReference20.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_assignment165);
                    valueExpression21=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression21.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:66:4: ^( EQUALS VERSIONED_VALUE STRING_LITERAL )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    EQUALS22=(CommonTree)match(input,EQUALS,FOLLOW_EQUALS_in_assignment172); 


                    if ( _first_0==null ) _first_0 = EQUALS22;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    VERSIONED_VALUE23=(CommonTree)match(input,VERSIONED_VALUE,FOLLOW_VERSIONED_VALUE_in_assignment174); 
                     
                    if ( _first_1==null ) _first_1 = VERSIONED_VALUE23;
                    _last = (CommonTree)input.LT(1);
                    STRING_LITERAL24=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_assignment176); 
                     
                    if ( _first_1==null ) _first_1 = STRING_LITERAL24;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class deleteStatementSet_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deleteStatementSet"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:69:1: deleteStatementSet : ( deleteStatement )+ ;
    public final TestHQLTreeWalker.deleteStatementSet_return deleteStatementSet() throws RecognitionException {
        TestHQLTreeWalker.deleteStatementSet_return retval = new TestHQLTreeWalker.deleteStatementSet_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.deleteStatement_return deleteStatement25 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:70:2: ( ( deleteStatement )+ )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:70:4: ( deleteStatement )+
            {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:70:4: ( deleteStatement )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==DELETE) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:70:4: deleteStatement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_deleteStatement_in_deleteStatementSet188);
            	    deleteStatement25=deleteStatement();

            	    state._fsp--;

            	     
            	    if ( _first_0==null ) _first_0 = deleteStatement25.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "deleteStatementSet"

    public static class deleteStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "deleteStatement"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:73:1: deleteStatement : ^( DELETE entityName ( whereClause )? ) ;
    public final TestHQLTreeWalker.deleteStatement_return deleteStatement() throws RecognitionException {
        TestHQLTreeWalker.deleteStatement_return retval = new TestHQLTreeWalker.deleteStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DELETE26=null;
        TestHQLTreeWalker.entityName_return entityName27 = null;

        TestHQLTreeWalker.whereClause_return whereClause28 = null;


        CommonTree DELETE26_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:74:2: ( ^( DELETE entityName ( whereClause )? ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:74:4: ^( DELETE entityName ( whereClause )? )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            DELETE26=(CommonTree)match(input,DELETE,FOLLOW_DELETE_in_deleteStatement201); 


            if ( _first_0==null ) _first_0 = DELETE26;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_entityName_in_deleteStatement203);
            entityName27=entityName();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = entityName27.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:74:24: ( whereClause )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==WHERE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:74:24: whereClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_whereClause_in_deleteStatement205);
                    whereClause28=whereClause();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = whereClause28.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "deleteStatement"

    public static class insertStatementSet_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insertStatementSet"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:77:1: insertStatementSet : ( insertStatement )+ ;
    public final TestHQLTreeWalker.insertStatementSet_return insertStatementSet() throws RecognitionException {
        TestHQLTreeWalker.insertStatementSet_return retval = new TestHQLTreeWalker.insertStatementSet_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.insertStatement_return insertStatement29 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:78:2: ( ( insertStatement )+ )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:78:4: ( insertStatement )+
            {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:78:4: ( insertStatement )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==INSERT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:78:4: insertStatement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_insertStatement_in_insertStatementSet218);
            	    insertStatement29=insertStatement();

            	    state._fsp--;

            	     
            	    if ( _first_0==null ) _first_0 = insertStatement29.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "insertStatementSet"

    public static class insertStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insertStatement"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:81:1: insertStatement : ^( INSERT intoClause queryStatementSet ) ;
    public final TestHQLTreeWalker.insertStatement_return insertStatement() throws RecognitionException {
        TestHQLTreeWalker.insertStatement_return retval = new TestHQLTreeWalker.insertStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INSERT30=null;
        TestHQLTreeWalker.intoClause_return intoClause31 = null;

        TestHQLTreeWalker.queryStatementSet_return queryStatementSet32 = null;


        CommonTree INSERT30_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:82:2: ( ^( INSERT intoClause queryStatementSet ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:82:4: ^( INSERT intoClause queryStatementSet )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            INSERT30=(CommonTree)match(input,INSERT,FOLLOW_INSERT_in_insertStatement231); 


            if ( _first_0==null ) _first_0 = INSERT30;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_intoClause_in_insertStatement233);
            intoClause31=intoClause();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = intoClause31.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_queryStatementSet_in_insertStatement235);
            queryStatementSet32=queryStatementSet();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = queryStatementSet32.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "insertStatement"

    public static class intoClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "intoClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:85:1: intoClause : ^( INTO entityName ^( INSERTABILITY_SPEC ( propertyReference )+ ) ) ;
    public final TestHQLTreeWalker.intoClause_return intoClause() throws RecognitionException {
        TestHQLTreeWalker.intoClause_return retval = new TestHQLTreeWalker.intoClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INTO33=null;
        CommonTree INSERTABILITY_SPEC35=null;
        TestHQLTreeWalker.entityName_return entityName34 = null;

        TestHQLTreeWalker.propertyReference_return propertyReference36 = null;


        CommonTree INTO33_tree=null;
        CommonTree INSERTABILITY_SPEC35_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:86:2: ( ^( INTO entityName ^( INSERTABILITY_SPEC ( propertyReference )+ ) ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:86:4: ^( INTO entityName ^( INSERTABILITY_SPEC ( propertyReference )+ ) )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            INTO33=(CommonTree)match(input,INTO,FOLLOW_INTO_in_intoClause248); 


            if ( _first_0==null ) _first_0 = INTO33;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_entityName_in_intoClause250);
            entityName34=entityName();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = entityName34.tree;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            _last = (CommonTree)input.LT(1);
            INSERTABILITY_SPEC35=(CommonTree)match(input,INSERTABILITY_SPEC,FOLLOW_INSERTABILITY_SPEC_in_intoClause253); 


            if ( _first_1==null ) _first_1 = INSERTABILITY_SPEC35;
            match(input, Token.DOWN, null); 
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:86:43: ( propertyReference )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==PROPERTY_REFERENCE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:86:43: propertyReference
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_propertyReference_in_intoClause255);
            	    propertyReference36=propertyReference();

            	    state._fsp--;

            	     
            	    if ( _first_2==null ) _first_2 = propertyReference36.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            match(input, Token.UP, null); _last = _save_last_2;
            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "intoClause"

    public static class queryStatementSet_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "queryStatementSet"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:89:1: queryStatementSet : ( queryStatement )+ ;
    public final TestHQLTreeWalker.queryStatementSet_return queryStatementSet() throws RecognitionException {
        TestHQLTreeWalker.queryStatementSet_return retval = new TestHQLTreeWalker.queryStatementSet_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.queryStatement_return queryStatement37 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:90:2: ( ( queryStatement )+ )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:90:4: ( queryStatement )+
            {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:90:4: ( queryStatement )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUERY) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:90:4: queryStatement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_queryStatement_in_queryStatementSet271);
            	    queryStatement37=queryStatement();

            	    state._fsp--;

            	     
            	    if ( _first_0==null ) _first_0 = queryStatement37.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "queryStatementSet"

    public static class queryStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "queryStatement"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:93:1: queryStatement : ^( QUERY queryExpression ( orderByClause )? ) ;
    public final TestHQLTreeWalker.queryStatement_return queryStatement() throws RecognitionException {
        TestHQLTreeWalker.queryStatement_return retval = new TestHQLTreeWalker.queryStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY38=null;
        TestHQLTreeWalker.queryExpression_return queryExpression39 = null;

        TestHQLTreeWalker.orderByClause_return orderByClause40 = null;


        CommonTree QUERY38_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:94:2: ( ^( QUERY queryExpression ( orderByClause )? ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:94:4: ^( QUERY queryExpression ( orderByClause )? )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            QUERY38=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_queryStatement284); 


            if ( _first_0==null ) _first_0 = QUERY38;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_queryExpression_in_queryStatement286);
            queryExpression39=queryExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = queryExpression39.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:94:28: ( orderByClause )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ORDER_BY) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:94:28: orderByClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_orderByClause_in_queryStatement288);
                    orderByClause40=orderByClause();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = orderByClause40.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "queryStatement"

    public static class queryExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "queryExpression"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:97:1: queryExpression : ( ^( UNION ( ALL )? queryExpression queryExpression ) | ^( INTERSECT ( ALL )? queryExpression queryExpression ) | ^( EXCEPT ( ALL )? queryExpression queryExpression ) | querySpec );
    public final TestHQLTreeWalker.queryExpression_return queryExpression() throws RecognitionException {
        TestHQLTreeWalker.queryExpression_return retval = new TestHQLTreeWalker.queryExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION41=null;
        CommonTree ALL42=null;
        CommonTree INTERSECT45=null;
        CommonTree ALL46=null;
        CommonTree EXCEPT49=null;
        CommonTree ALL50=null;
        TestHQLTreeWalker.queryExpression_return queryExpression43 = null;

        TestHQLTreeWalker.queryExpression_return queryExpression44 = null;

        TestHQLTreeWalker.queryExpression_return queryExpression47 = null;

        TestHQLTreeWalker.queryExpression_return queryExpression48 = null;

        TestHQLTreeWalker.queryExpression_return queryExpression51 = null;

        TestHQLTreeWalker.queryExpression_return queryExpression52 = null;

        TestHQLTreeWalker.querySpec_return querySpec53 = null;


        CommonTree UNION41_tree=null;
        CommonTree ALL42_tree=null;
        CommonTree INTERSECT45_tree=null;
        CommonTree ALL46_tree=null;
        CommonTree EXCEPT49_tree=null;
        CommonTree ALL50_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:98:2: ( ^( UNION ( ALL )? queryExpression queryExpression ) | ^( INTERSECT ( ALL )? queryExpression queryExpression ) | ^( EXCEPT ( ALL )? queryExpression queryExpression ) | querySpec )
            int alt20=4;
            switch ( input.LA(1) ) {
            case UNION:
                {
                alt20=1;
                }
                break;
            case INTERSECT:
                {
                alt20=2;
                }
                break;
            case EXCEPT:
                {
                alt20=3;
                }
                break;
            case QUERY_SPEC:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:98:4: ^( UNION ( ALL )? queryExpression queryExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    UNION41=(CommonTree)match(input,UNION,FOLLOW_UNION_in_queryExpression302); 


                    if ( _first_0==null ) _first_0 = UNION41;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:98:12: ( ALL )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==ALL) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:98:12: ALL
                            {
                            _last = (CommonTree)input.LT(1);
                            ALL42=(CommonTree)match(input,ALL,FOLLOW_ALL_in_queryExpression304); 
                             
                            if ( _first_1==null ) _first_1 = ALL42;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_queryExpression_in_queryExpression307);
                    queryExpression43=queryExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = queryExpression43.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_queryExpression_in_queryExpression309);
                    queryExpression44=queryExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = queryExpression44.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:99:4: ^( INTERSECT ( ALL )? queryExpression queryExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    INTERSECT45=(CommonTree)match(input,INTERSECT,FOLLOW_INTERSECT_in_queryExpression316); 


                    if ( _first_0==null ) _first_0 = INTERSECT45;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:99:16: ( ALL )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==ALL) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:99:16: ALL
                            {
                            _last = (CommonTree)input.LT(1);
                            ALL46=(CommonTree)match(input,ALL,FOLLOW_ALL_in_queryExpression318); 
                             
                            if ( _first_1==null ) _first_1 = ALL46;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_queryExpression_in_queryExpression321);
                    queryExpression47=queryExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = queryExpression47.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_queryExpression_in_queryExpression323);
                    queryExpression48=queryExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = queryExpression48.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:100:4: ^( EXCEPT ( ALL )? queryExpression queryExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    EXCEPT49=(CommonTree)match(input,EXCEPT,FOLLOW_EXCEPT_in_queryExpression330); 


                    if ( _first_0==null ) _first_0 = EXCEPT49;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:100:13: ( ALL )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==ALL) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:100:13: ALL
                            {
                            _last = (CommonTree)input.LT(1);
                            ALL50=(CommonTree)match(input,ALL,FOLLOW_ALL_in_queryExpression332); 
                             
                            if ( _first_1==null ) _first_1 = ALL50;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_queryExpression_in_queryExpression335);
                    queryExpression51=queryExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = queryExpression51.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_queryExpression_in_queryExpression337);
                    queryExpression52=queryExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = queryExpression52.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:101:4: querySpec
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_querySpec_in_queryExpression343);
                    querySpec53=querySpec();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = querySpec53.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "queryExpression"

    public static class querySpec_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "querySpec"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:104:1: querySpec : ^( QUERY_SPEC selectFrom ( whereClause )? ( groupByClause )? ( havingClause )? ) ;
    public final TestHQLTreeWalker.querySpec_return querySpec() throws RecognitionException {
        TestHQLTreeWalker.querySpec_return retval = new TestHQLTreeWalker.querySpec_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY_SPEC54=null;
        TestHQLTreeWalker.selectFrom_return selectFrom55 = null;

        TestHQLTreeWalker.whereClause_return whereClause56 = null;

        TestHQLTreeWalker.groupByClause_return groupByClause57 = null;

        TestHQLTreeWalker.havingClause_return havingClause58 = null;


        CommonTree QUERY_SPEC54_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:105:2: ( ^( QUERY_SPEC selectFrom ( whereClause )? ( groupByClause )? ( havingClause )? ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:105:4: ^( QUERY_SPEC selectFrom ( whereClause )? ( groupByClause )? ( havingClause )? )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            QUERY_SPEC54=(CommonTree)match(input,QUERY_SPEC,FOLLOW_QUERY_SPEC_in_querySpec356); 


            if ( _first_0==null ) _first_0 = QUERY_SPEC54;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_selectFrom_in_querySpec358);
            selectFrom55=selectFrom();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = selectFrom55.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:105:28: ( whereClause )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==WHERE) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:105:28: whereClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_whereClause_in_querySpec360);
                    whereClause56=whereClause();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = whereClause56.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }

            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:105:41: ( groupByClause )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==GROUP_BY) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:105:41: groupByClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_groupByClause_in_querySpec363);
                    groupByClause57=groupByClause();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = groupByClause57.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }

            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:105:56: ( havingClause )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==HAVING) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:105:56: havingClause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_havingClause_in_querySpec366);
                    havingClause58=havingClause();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = havingClause58.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "querySpec"

    public static class whereClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whereClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:108:1: whereClause : ^( WHERE searchCondition ) ;
    public final TestHQLTreeWalker.whereClause_return whereClause() throws RecognitionException {
        TestHQLTreeWalker.whereClause_return retval = new TestHQLTreeWalker.whereClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHERE59=null;
        TestHQLTreeWalker.searchCondition_return searchCondition60 = null;


        CommonTree WHERE59_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:109:2: ( ^( WHERE searchCondition ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:109:4: ^( WHERE searchCondition )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            WHERE59=(CommonTree)match(input,WHERE,FOLLOW_WHERE_in_whereClause380); 


            if ( _first_0==null ) _first_0 = WHERE59;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_searchCondition_in_whereClause382);
            searchCondition60=searchCondition();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = searchCondition60.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "whereClause"

    public static class groupByClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupByClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:112:1: groupByClause : ^( GROUP_BY ( groupingValue )+ ) ;
    public final TestHQLTreeWalker.groupByClause_return groupByClause() throws RecognitionException {
        TestHQLTreeWalker.groupByClause_return retval = new TestHQLTreeWalker.groupByClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP_BY61=null;
        TestHQLTreeWalker.groupingValue_return groupingValue62 = null;


        CommonTree GROUP_BY61_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:113:2: ( ^( GROUP_BY ( groupingValue )+ ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:113:4: ^( GROUP_BY ( groupingValue )+ )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            GROUP_BY61=(CommonTree)match(input,GROUP_BY,FOLLOW_GROUP_BY_in_groupByClause395); 


            if ( _first_0==null ) _first_0 = GROUP_BY61;
            match(input, Token.DOWN, null); 
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:113:15: ( groupingValue )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==GROUPING_VALUE) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:113:15: groupingValue
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_groupingValue_in_groupByClause397);
            	    groupingValue62=groupingValue();

            	    state._fsp--;

            	     
            	    if ( _first_1==null ) _first_1 = groupingValue62.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groupByClause"

    public static class groupingValue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupingValue"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:116:1: groupingValue : ^( GROUPING_VALUE valueExpression ( COLLATE )? ) ;
    public final TestHQLTreeWalker.groupingValue_return groupingValue() throws RecognitionException {
        TestHQLTreeWalker.groupingValue_return retval = new TestHQLTreeWalker.groupingValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUPING_VALUE63=null;
        CommonTree COLLATE65=null;
        TestHQLTreeWalker.valueExpression_return valueExpression64 = null;


        CommonTree GROUPING_VALUE63_tree=null;
        CommonTree COLLATE65_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:117:2: ( ^( GROUPING_VALUE valueExpression ( COLLATE )? ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:117:4: ^( GROUPING_VALUE valueExpression ( COLLATE )? )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            GROUPING_VALUE63=(CommonTree)match(input,GROUPING_VALUE,FOLLOW_GROUPING_VALUE_in_groupingValue411); 


            if ( _first_0==null ) _first_0 = GROUPING_VALUE63;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_groupingValue413);
            valueExpression64=valueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = valueExpression64.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:117:37: ( COLLATE )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==COLLATE) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:117:37: COLLATE
                    {
                    _last = (CommonTree)input.LT(1);
                    COLLATE65=(CommonTree)match(input,COLLATE,FOLLOW_COLLATE_in_groupingValue415); 
                     
                    if ( _first_1==null ) _first_1 = COLLATE65;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groupingValue"

    public static class havingClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "havingClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:120:1: havingClause : ^( HAVING searchCondition ) ;
    public final TestHQLTreeWalker.havingClause_return havingClause() throws RecognitionException {
        TestHQLTreeWalker.havingClause_return retval = new TestHQLTreeWalker.havingClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree HAVING66=null;
        TestHQLTreeWalker.searchCondition_return searchCondition67 = null;


        CommonTree HAVING66_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:121:2: ( ^( HAVING searchCondition ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:121:4: ^( HAVING searchCondition )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            HAVING66=(CommonTree)match(input,HAVING,FOLLOW_HAVING_in_havingClause429); 


            if ( _first_0==null ) _first_0 = HAVING66;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_searchCondition_in_havingClause431);
            searchCondition67=searchCondition();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = searchCondition67.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "havingClause"

    public static class selectFrom_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectFrom"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:124:1: selectFrom : ^( SELECT_FROM fromClause selectClause ) ;
    public final TestHQLTreeWalker.selectFrom_return selectFrom() throws RecognitionException {
        TestHQLTreeWalker.selectFrom_return retval = new TestHQLTreeWalker.selectFrom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SELECT_FROM68=null;
        TestHQLTreeWalker.fromClause_return fromClause69 = null;

        TestHQLTreeWalker.selectClause_return selectClause70 = null;


        CommonTree SELECT_FROM68_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:125:2: ( ^( SELECT_FROM fromClause selectClause ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:125:4: ^( SELECT_FROM fromClause selectClause )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            SELECT_FROM68=(CommonTree)match(input,SELECT_FROM,FOLLOW_SELECT_FROM_in_selectFrom444); 


            if ( _first_0==null ) _first_0 = SELECT_FROM68;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_fromClause_in_selectFrom446);
            fromClause69=fromClause();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = fromClause69.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_selectClause_in_selectFrom448);
            selectClause70=selectClause();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = selectClause70.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "selectFrom"

    public static class fromClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fromClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:128:1: fromClause : ^( FROM ( persisterSpaces )+ ) ;
    public final TestHQLTreeWalker.fromClause_return fromClause() throws RecognitionException {
        TestHQLTreeWalker.fromClause_return retval = new TestHQLTreeWalker.fromClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FROM71=null;
        TestHQLTreeWalker.persisterSpaces_return persisterSpaces72 = null;


        CommonTree FROM71_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:129:2: ( ^( FROM ( persisterSpaces )+ ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:129:4: ^( FROM ( persisterSpaces )+ )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            FROM71=(CommonTree)match(input,FROM,FOLLOW_FROM_in_fromClause461); 


            if ( _first_0==null ) _first_0 = FROM71;
            match(input, Token.DOWN, null); 
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:129:11: ( persisterSpaces )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==PERSISTER_SPACE) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:129:11: persisterSpaces
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_persisterSpaces_in_fromClause463);
            	    persisterSpaces72=persisterSpaces();

            	    state._fsp--;

            	     
            	    if ( _first_1==null ) _first_1 = persisterSpaces72.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fromClause"

    public static class persisterSpaces_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "persisterSpaces"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:132:1: persisterSpaces : ^( PERSISTER_SPACE persisterSpace ) ;
    public final TestHQLTreeWalker.persisterSpaces_return persisterSpaces() throws RecognitionException {
        TestHQLTreeWalker.persisterSpaces_return retval = new TestHQLTreeWalker.persisterSpaces_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERSISTER_SPACE73=null;
        TestHQLTreeWalker.persisterSpace_return persisterSpace74 = null;


        CommonTree PERSISTER_SPACE73_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:133:2: ( ^( PERSISTER_SPACE persisterSpace ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:133:4: ^( PERSISTER_SPACE persisterSpace )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            PERSISTER_SPACE73=(CommonTree)match(input,PERSISTER_SPACE,FOLLOW_PERSISTER_SPACE_in_persisterSpaces477); 


            if ( _first_0==null ) _first_0 = PERSISTER_SPACE73;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_persisterSpace_in_persisterSpaces479);
            persisterSpace74=persisterSpace();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = persisterSpace74.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "persisterSpaces"

    public static class persisterSpace_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "persisterSpace"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:136:1: persisterSpace : persisterSpaceRoot ( joins )* ;
    public final TestHQLTreeWalker.persisterSpace_return persisterSpace() throws RecognitionException {
        TestHQLTreeWalker.persisterSpace_return retval = new TestHQLTreeWalker.persisterSpace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.persisterSpaceRoot_return persisterSpaceRoot75 = null;

        TestHQLTreeWalker.joins_return joins76 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:137:2: ( persisterSpaceRoot ( joins )* )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:137:4: persisterSpaceRoot ( joins )*
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_persisterSpaceRoot_in_persisterSpace491);
            persisterSpaceRoot75=persisterSpaceRoot();

            state._fsp--;

             
            if ( _first_0==null ) _first_0 = persisterSpaceRoot75.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:137:23: ( joins )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==PERSISTER_JOIN||LA27_0==PROPERTY_JOIN) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:137:23: joins
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_joins_in_persisterSpace493);
            	    joins76=joins();

            	    state._fsp--;

            	     
            	    if ( _first_0==null ) _first_0 = joins76.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "persisterSpace"

    public static class persisterSpaceRoot_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "persisterSpaceRoot"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:140:1: persisterSpaceRoot : ^( ENTITY_PERSISTER_REF entityName ( PROP_FETCH )? ) ;
    public final TestHQLTreeWalker.persisterSpaceRoot_return persisterSpaceRoot() throws RecognitionException {
        TestHQLTreeWalker.persisterSpaceRoot_return retval = new TestHQLTreeWalker.persisterSpaceRoot_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ENTITY_PERSISTER_REF77=null;
        CommonTree PROP_FETCH79=null;
        TestHQLTreeWalker.entityName_return entityName78 = null;


        CommonTree ENTITY_PERSISTER_REF77_tree=null;
        CommonTree PROP_FETCH79_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:141:2: ( ^( ENTITY_PERSISTER_REF entityName ( PROP_FETCH )? ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:141:4: ^( ENTITY_PERSISTER_REF entityName ( PROP_FETCH )? )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            ENTITY_PERSISTER_REF77=(CommonTree)match(input,ENTITY_PERSISTER_REF,FOLLOW_ENTITY_PERSISTER_REF_in_persisterSpaceRoot506); 


            if ( _first_0==null ) _first_0 = ENTITY_PERSISTER_REF77;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_entityName_in_persisterSpaceRoot508);
            entityName78=entityName();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = entityName78.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:141:38: ( PROP_FETCH )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==PROP_FETCH) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:141:38: PROP_FETCH
                    {
                    _last = (CommonTree)input.LT(1);
                    PROP_FETCH79=(CommonTree)match(input,PROP_FETCH,FOLLOW_PROP_FETCH_in_persisterSpaceRoot510); 
                     
                    if ( _first_1==null ) _first_1 = PROP_FETCH79;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "persisterSpaceRoot"

    public static class joins_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "joins"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:144:1: joins : ( ^( PROPERTY_JOIN joinType ( FETCH )? ALIAS_NAME ( PROP_FETCH )? ( collectionExpression | propertyReference ) ( withClause )? ) | ^( PERSISTER_JOIN joinType persisterSpaceRoot ( onClause )? ) );
    public final TestHQLTreeWalker.joins_return joins() throws RecognitionException {
        TestHQLTreeWalker.joins_return retval = new TestHQLTreeWalker.joins_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PROPERTY_JOIN80=null;
        CommonTree FETCH82=null;
        CommonTree ALIAS_NAME83=null;
        CommonTree PROP_FETCH84=null;
        CommonTree PERSISTER_JOIN88=null;
        TestHQLTreeWalker.joinType_return joinType81 = null;

        TestHQLTreeWalker.collectionExpression_return collectionExpression85 = null;

        TestHQLTreeWalker.propertyReference_return propertyReference86 = null;

        TestHQLTreeWalker.withClause_return withClause87 = null;

        TestHQLTreeWalker.joinType_return joinType89 = null;

        TestHQLTreeWalker.persisterSpaceRoot_return persisterSpaceRoot90 = null;

        TestHQLTreeWalker.onClause_return onClause91 = null;


        CommonTree PROPERTY_JOIN80_tree=null;
        CommonTree FETCH82_tree=null;
        CommonTree ALIAS_NAME83_tree=null;
        CommonTree PROP_FETCH84_tree=null;
        CommonTree PERSISTER_JOIN88_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:2: ( ^( PROPERTY_JOIN joinType ( FETCH )? ALIAS_NAME ( PROP_FETCH )? ( collectionExpression | propertyReference ) ( withClause )? ) | ^( PERSISTER_JOIN joinType persisterSpaceRoot ( onClause )? ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==PROPERTY_JOIN) ) {
                alt34=1;
            }
            else if ( (LA34_0==PERSISTER_JOIN) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:4: ^( PROPERTY_JOIN joinType ( FETCH )? ALIAS_NAME ( PROP_FETCH )? ( collectionExpression | propertyReference ) ( withClause )? )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    PROPERTY_JOIN80=(CommonTree)match(input,PROPERTY_JOIN,FOLLOW_PROPERTY_JOIN_in_joins524); 


                    if ( _first_0==null ) _first_0 = PROPERTY_JOIN80;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_joinType_in_joins526);
                    joinType81=joinType();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = joinType81.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:29: ( FETCH )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==FETCH) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:29: FETCH
                            {
                            _last = (CommonTree)input.LT(1);
                            FETCH82=(CommonTree)match(input,FETCH,FOLLOW_FETCH_in_joins528); 
                             
                            if ( _first_1==null ) _first_1 = FETCH82;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }

                    _last = (CommonTree)input.LT(1);
                    ALIAS_NAME83=(CommonTree)match(input,ALIAS_NAME,FOLLOW_ALIAS_NAME_in_joins531); 
                     
                    if ( _first_1==null ) _first_1 = ALIAS_NAME83;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:47: ( PROP_FETCH )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==PROP_FETCH) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:47: PROP_FETCH
                            {
                            _last = (CommonTree)input.LT(1);
                            PROP_FETCH84=(CommonTree)match(input,PROP_FETCH,FOLLOW_PROP_FETCH_in_joins533); 
                             
                            if ( _first_1==null ) _first_1 = PROP_FETCH84;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }

                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:59: ( collectionExpression | propertyReference )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==ELEMENTS||LA31_0==INDICES) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==PROPERTY_REFERENCE) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:60: collectionExpression
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_collectionExpression_in_joins537);
                            collectionExpression85=collectionExpression();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = collectionExpression85.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;
                        case 2 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:81: propertyReference
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_propertyReference_in_joins539);
                            propertyReference86=propertyReference();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = propertyReference86.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }

                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:100: ( withClause )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==WITH) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:145:100: withClause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_withClause_in_joins542);
                            withClause87=withClause();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = withClause87.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:146:4: ^( PERSISTER_JOIN joinType persisterSpaceRoot ( onClause )? )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    PERSISTER_JOIN88=(CommonTree)match(input,PERSISTER_JOIN,FOLLOW_PERSISTER_JOIN_in_joins550); 


                    if ( _first_0==null ) _first_0 = PERSISTER_JOIN88;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_joinType_in_joins552);
                    joinType89=joinType();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = joinType89.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_persisterSpaceRoot_in_joins554);
                    persisterSpaceRoot90=persisterSpaceRoot();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = persisterSpaceRoot90.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:146:49: ( onClause )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==ON) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:146:49: onClause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_onClause_in_joins556);
                            onClause91=onClause();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = onClause91.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "joins"

    public static class withClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "withClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:149:1: withClause : ^( WITH searchCondition ) ;
    public final TestHQLTreeWalker.withClause_return withClause() throws RecognitionException {
        TestHQLTreeWalker.withClause_return retval = new TestHQLTreeWalker.withClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WITH92=null;
        TestHQLTreeWalker.searchCondition_return searchCondition93 = null;


        CommonTree WITH92_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:150:2: ( ^( WITH searchCondition ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:150:4: ^( WITH searchCondition )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            WITH92=(CommonTree)match(input,WITH,FOLLOW_WITH_in_withClause570); 


            if ( _first_0==null ) _first_0 = WITH92;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_searchCondition_in_withClause572);
            searchCondition93=searchCondition();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = searchCondition93.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "withClause"

    public static class onClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "onClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:153:1: onClause : ^( ON searchCondition ) ;
    public final TestHQLTreeWalker.onClause_return onClause() throws RecognitionException {
        TestHQLTreeWalker.onClause_return retval = new TestHQLTreeWalker.onClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ON94=null;
        TestHQLTreeWalker.searchCondition_return searchCondition95 = null;


        CommonTree ON94_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:154:2: ( ^( ON searchCondition ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:154:4: ^( ON searchCondition )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            ON94=(CommonTree)match(input,ON,FOLLOW_ON_in_onClause585); 


            if ( _first_0==null ) _first_0 = ON94;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_searchCondition_in_onClause587);
            searchCondition95=searchCondition();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = searchCondition95.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "onClause"

    public static class joinType_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "joinType"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:157:1: joinType : ( CROSS | INNER | ( LEFT | RIGHT | FULL ) ( OUTER )? );
    public final TestHQLTreeWalker.joinType_return joinType() throws RecognitionException {
        TestHQLTreeWalker.joinType_return retval = new TestHQLTreeWalker.joinType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS96=null;
        CommonTree INNER97=null;
        CommonTree set98=null;
        CommonTree OUTER99=null;

        CommonTree CROSS96_tree=null;
        CommonTree INNER97_tree=null;
        CommonTree set98_tree=null;
        CommonTree OUTER99_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:158:2: ( CROSS | INNER | ( LEFT | RIGHT | FULL ) ( OUTER )? )
            int alt36=3;
            switch ( input.LA(1) ) {
            case CROSS:
                {
                alt36=1;
                }
                break;
            case INNER:
                {
                alt36=2;
                }
                break;
            case FULL:
            case LEFT:
            case RIGHT:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:158:4: CROSS
                    {
                    _last = (CommonTree)input.LT(1);
                    CROSS96=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_joinType599); 
                     
                    if ( _first_0==null ) _first_0 = CROSS96;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:159:4: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER97=(CommonTree)match(input,INNER,FOLLOW_INNER_in_joinType604); 
                     
                    if ( _first_0==null ) _first_0 = INNER97;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:160:4: ( LEFT | RIGHT | FULL ) ( OUTER )?
                    {
                    _last = (CommonTree)input.LT(1);
                    set98=(CommonTree)input.LT(1);
                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();


                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:160:26: ( OUTER )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==OUTER) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:160:26: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER99=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_joinType621); 
                             
                            if ( _first_0==null ) _first_0 = OUTER99;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "joinType"

    public static class selectClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:163:1: selectClause : ^( SELECT ( DISTINCT )? rootSelectExpression ) ;
    public final TestHQLTreeWalker.selectClause_return selectClause() throws RecognitionException {
        TestHQLTreeWalker.selectClause_return retval = new TestHQLTreeWalker.selectClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SELECT100=null;
        CommonTree DISTINCT101=null;
        TestHQLTreeWalker.rootSelectExpression_return rootSelectExpression102 = null;


        CommonTree SELECT100_tree=null;
        CommonTree DISTINCT101_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:164:2: ( ^( SELECT ( DISTINCT )? rootSelectExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:164:4: ^( SELECT ( DISTINCT )? rootSelectExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            SELECT100=(CommonTree)match(input,SELECT,FOLLOW_SELECT_in_selectClause634); 


            if ( _first_0==null ) _first_0 = SELECT100;
            match(input, Token.DOWN, null); 
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:164:13: ( DISTINCT )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==DISTINCT) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:164:13: DISTINCT
                    {
                    _last = (CommonTree)input.LT(1);
                    DISTINCT101=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_selectClause636); 
                     
                    if ( _first_1==null ) _first_1 = DISTINCT101;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rootSelectExpression_in_selectClause639);
            rootSelectExpression102=rootSelectExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = rootSelectExpression102.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "selectClause"

    public static class rootSelectExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rootSelectExpression"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:167:1: rootSelectExpression : ( ^( SELECT_LIST ( rootSelectExpression )+ ) | ^( SELECT_ITEM rootSelectExpression ) | ^( DYNAMIC_INSTANTIATION ( rootSelectExpression )+ ) | ^( DYNAMIC_INSTANTIATION_ARG rootSelectExpression ) | valueExpression ( ALIAS_NAME )? );
    public final TestHQLTreeWalker.rootSelectExpression_return rootSelectExpression() throws RecognitionException {
        TestHQLTreeWalker.rootSelectExpression_return retval = new TestHQLTreeWalker.rootSelectExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SELECT_LIST103=null;
        CommonTree SELECT_ITEM105=null;
        CommonTree DYNAMIC_INSTANTIATION107=null;
        CommonTree DYNAMIC_INSTANTIATION_ARG109=null;
        CommonTree ALIAS_NAME112=null;
        TestHQLTreeWalker.rootSelectExpression_return rootSelectExpression104 = null;

        TestHQLTreeWalker.rootSelectExpression_return rootSelectExpression106 = null;

        TestHQLTreeWalker.rootSelectExpression_return rootSelectExpression108 = null;

        TestHQLTreeWalker.rootSelectExpression_return rootSelectExpression110 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression111 = null;


        CommonTree SELECT_LIST103_tree=null;
        CommonTree SELECT_ITEM105_tree=null;
        CommonTree DYNAMIC_INSTANTIATION107_tree=null;
        CommonTree DYNAMIC_INSTANTIATION_ARG109_tree=null;
        CommonTree ALIAS_NAME112_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:168:2: ( ^( SELECT_LIST ( rootSelectExpression )+ ) | ^( SELECT_ITEM rootSelectExpression ) | ^( DYNAMIC_INSTANTIATION ( rootSelectExpression )+ ) | ^( DYNAMIC_INSTANTIATION_ARG rootSelectExpression ) | valueExpression ( ALIAS_NAME )? )
            int alt41=5;
            switch ( input.LA(1) ) {
            case SELECT_LIST:
                {
                alt41=1;
                }
                break;
            case SELECT_ITEM:
                {
                alt41=2;
                }
                break;
            case DYNAMIC_INSTANTIATION:
                {
                alt41=3;
                }
                break;
            case DYNAMIC_INSTANTIATION_ARG:
                {
                alt41=4;
                }
                break;
            case ALIAS_REF:
            case DOT_CLASS:
            case JAVA_CONSTANT:
            case JPA_PARAM:
            case NAMED_PARAM:
            case PATH:
            case PROPERTY_REFERENCE:
            case SEARCHED_CASE:
            case SIMPLE_CASE:
            case SUB_QUERY:
            case UNARY_MINUS:
            case UNARY_PLUS:
            case VECTOR_EXPR:
            case ABS:
            case ALL:
            case ANY:
            case AVG:
            case BIT_LENGTH:
            case CAST:
            case CHARACTER_LENGTH:
            case COALESCE:
            case CONCAT:
            case COUNT:
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
            case ELEMENTS:
            case EXISTS:
            case EXTRACT:
            case INDEX:
            case INDICES:
            case LENGTH:
            case LOCATE:
            case LOWER:
            case MAX:
            case MAXELEMENT:
            case MAXINDEX:
            case MIN:
            case MINELEMENT:
            case MININDEX:
            case MOD:
            case NULLIF:
            case OCTET_LENGTH:
            case POSITION:
            case SIZE:
            case SOME:
            case SQRT:
            case SUBSTRING:
            case SUM:
            case TRIM:
            case UPPER:
            case HEX_LITERAL:
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
            case OCTAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case TRUE:
            case FALSE:
            case NULL:
            case DOUBLE_PIPE:
            case PARAM:
            case PLUS:
            case MINUS:
            case ASTERISK:
            case SOLIDUS:
            case GENERAL_FUNCTION_CALL:
                {
                alt41=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:168:4: ^( SELECT_LIST ( rootSelectExpression )+ )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    SELECT_LIST103=(CommonTree)match(input,SELECT_LIST,FOLLOW_SELECT_LIST_in_rootSelectExpression653); 


                    if ( _first_0==null ) _first_0 = SELECT_LIST103;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:168:18: ( rootSelectExpression )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==ALIAS_REF||(LA38_0>=DOT_CLASS && LA38_0<=DYNAMIC_INSTANTIATION)||(LA38_0>=JAVA_CONSTANT && LA38_0<=NAMED_PARAM)||LA38_0==PATH||LA38_0==PROPERTY_REFERENCE||LA38_0==SEARCHED_CASE||(LA38_0>=SELECT_ITEM && LA38_0<=SIMPLE_CASE)||(LA38_0>=SUB_QUERY && LA38_0<=VECTOR_EXPR)||(LA38_0>=ABS && LA38_0<=ALL)||LA38_0==ANY||LA38_0==AVG||LA38_0==BIT_LENGTH||(LA38_0>=CAST && LA38_0<=CHARACTER_LENGTH)||(LA38_0>=COALESCE && LA38_0<=COUNT)||(LA38_0>=CURRENT_DATE && LA38_0<=CURRENT_TIMESTAMP)||LA38_0==ELEMENTS||(LA38_0>=EXISTS && LA38_0<=EXTRACT)||(LA38_0>=INDEX && LA38_0<=INDICES)||LA38_0==LENGTH||(LA38_0>=LOCATE && LA38_0<=MAXINDEX)||(LA38_0>=MIN && LA38_0<=MININDEX)||LA38_0==MOD||(LA38_0>=NULLIF && LA38_0<=OCTET_LENGTH)||LA38_0==POSITION||(LA38_0>=SIZE && LA38_0<=SUM)||LA38_0==TRIM||LA38_0==UPPER||(LA38_0>=HEX_LITERAL && LA38_0<=OCTAL_LITERAL)||LA38_0==FLOATING_POINT_LITERAL||(LA38_0>=CHARACTER_LITERAL && LA38_0<=STRING_LITERAL)||(LA38_0>=TRUE && LA38_0<=NULL)||(LA38_0>=DOUBLE_PIPE && LA38_0<=PARAM)||(LA38_0>=PLUS && LA38_0<=SOLIDUS)||LA38_0==GENERAL_FUNCTION_CALL) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:168:18: rootSelectExpression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rootSelectExpression_in_rootSelectExpression655);
                    	    rootSelectExpression104=rootSelectExpression();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = rootSelectExpression104.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:169:4: ^( SELECT_ITEM rootSelectExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    SELECT_ITEM105=(CommonTree)match(input,SELECT_ITEM,FOLLOW_SELECT_ITEM_in_rootSelectExpression663); 


                    if ( _first_0==null ) _first_0 = SELECT_ITEM105;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rootSelectExpression_in_rootSelectExpression665);
                    rootSelectExpression106=rootSelectExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rootSelectExpression106.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:170:4: ^( DYNAMIC_INSTANTIATION ( rootSelectExpression )+ )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    DYNAMIC_INSTANTIATION107=(CommonTree)match(input,DYNAMIC_INSTANTIATION,FOLLOW_DYNAMIC_INSTANTIATION_in_rootSelectExpression672); 


                    if ( _first_0==null ) _first_0 = DYNAMIC_INSTANTIATION107;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:170:28: ( rootSelectExpression )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==ALIAS_REF||(LA39_0>=DOT_CLASS && LA39_0<=DYNAMIC_INSTANTIATION)||(LA39_0>=JAVA_CONSTANT && LA39_0<=NAMED_PARAM)||LA39_0==PATH||LA39_0==PROPERTY_REFERENCE||LA39_0==SEARCHED_CASE||(LA39_0>=SELECT_ITEM && LA39_0<=SIMPLE_CASE)||(LA39_0>=SUB_QUERY && LA39_0<=VECTOR_EXPR)||(LA39_0>=ABS && LA39_0<=ALL)||LA39_0==ANY||LA39_0==AVG||LA39_0==BIT_LENGTH||(LA39_0>=CAST && LA39_0<=CHARACTER_LENGTH)||(LA39_0>=COALESCE && LA39_0<=COUNT)||(LA39_0>=CURRENT_DATE && LA39_0<=CURRENT_TIMESTAMP)||LA39_0==ELEMENTS||(LA39_0>=EXISTS && LA39_0<=EXTRACT)||(LA39_0>=INDEX && LA39_0<=INDICES)||LA39_0==LENGTH||(LA39_0>=LOCATE && LA39_0<=MAXINDEX)||(LA39_0>=MIN && LA39_0<=MININDEX)||LA39_0==MOD||(LA39_0>=NULLIF && LA39_0<=OCTET_LENGTH)||LA39_0==POSITION||(LA39_0>=SIZE && LA39_0<=SUM)||LA39_0==TRIM||LA39_0==UPPER||(LA39_0>=HEX_LITERAL && LA39_0<=OCTAL_LITERAL)||LA39_0==FLOATING_POINT_LITERAL||(LA39_0>=CHARACTER_LITERAL && LA39_0<=STRING_LITERAL)||(LA39_0>=TRUE && LA39_0<=NULL)||(LA39_0>=DOUBLE_PIPE && LA39_0<=PARAM)||(LA39_0>=PLUS && LA39_0<=SOLIDUS)||LA39_0==GENERAL_FUNCTION_CALL) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:170:28: rootSelectExpression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rootSelectExpression_in_rootSelectExpression674);
                    	    rootSelectExpression108=rootSelectExpression();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = rootSelectExpression108.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt39 >= 1 ) break loop39;
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:171:4: ^( DYNAMIC_INSTANTIATION_ARG rootSelectExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    DYNAMIC_INSTANTIATION_ARG109=(CommonTree)match(input,DYNAMIC_INSTANTIATION_ARG,FOLLOW_DYNAMIC_INSTANTIATION_ARG_in_rootSelectExpression682); 


                    if ( _first_0==null ) _first_0 = DYNAMIC_INSTANTIATION_ARG109;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rootSelectExpression_in_rootSelectExpression684);
                    rootSelectExpression110=rootSelectExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rootSelectExpression110.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 5 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:172:4: valueExpression ( ALIAS_NAME )?
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_rootSelectExpression690);
                    valueExpression111=valueExpression();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = valueExpression111.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:172:20: ( ALIAS_NAME )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==ALIAS_NAME) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:172:20: ALIAS_NAME
                            {
                            _last = (CommonTree)input.LT(1);
                            ALIAS_NAME112=(CommonTree)match(input,ALIAS_NAME,FOLLOW_ALIAS_NAME_in_rootSelectExpression692); 
                             
                            if ( _first_0==null ) _first_0 = ALIAS_NAME112;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rootSelectExpression"

    public static class orderByClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orderByClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:175:1: orderByClause : ^( ORDER_BY ( sortSpecification )+ ) ;
    public final TestHQLTreeWalker.orderByClause_return orderByClause() throws RecognitionException {
        TestHQLTreeWalker.orderByClause_return retval = new TestHQLTreeWalker.orderByClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER_BY113=null;
        TestHQLTreeWalker.sortSpecification_return sortSpecification114 = null;


        CommonTree ORDER_BY113_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:176:2: ( ^( ORDER_BY ( sortSpecification )+ ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:176:4: ^( ORDER_BY ( sortSpecification )+ )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            ORDER_BY113=(CommonTree)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderByClause705); 


            if ( _first_0==null ) _first_0 = ORDER_BY113;
            match(input, Token.DOWN, null); 
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:176:15: ( sortSpecification )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==SORT_SPEC) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:176:15: sortSpecification
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_sortSpecification_in_orderByClause707);
            	    sortSpecification114=sortSpecification();

            	    state._fsp--;

            	     
            	    if ( _first_1==null ) _first_1 = sortSpecification114.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt42 >= 1 ) break loop42;
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
            } while (true);


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "orderByClause"

    public static class sortSpecification_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sortSpecification"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:179:1: sortSpecification : ^( SORT_SPEC valueExpression ( COLLATE )? ORDER_SPEC ) ;
    public final TestHQLTreeWalker.sortSpecification_return sortSpecification() throws RecognitionException {
        TestHQLTreeWalker.sortSpecification_return retval = new TestHQLTreeWalker.sortSpecification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SORT_SPEC115=null;
        CommonTree COLLATE117=null;
        CommonTree ORDER_SPEC118=null;
        TestHQLTreeWalker.valueExpression_return valueExpression116 = null;


        CommonTree SORT_SPEC115_tree=null;
        CommonTree COLLATE117_tree=null;
        CommonTree ORDER_SPEC118_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:180:2: ( ^( SORT_SPEC valueExpression ( COLLATE )? ORDER_SPEC ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:180:4: ^( SORT_SPEC valueExpression ( COLLATE )? ORDER_SPEC )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            SORT_SPEC115=(CommonTree)match(input,SORT_SPEC,FOLLOW_SORT_SPEC_in_sortSpecification721); 


            if ( _first_0==null ) _first_0 = SORT_SPEC115;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_sortSpecification723);
            valueExpression116=valueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = valueExpression116.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:180:32: ( COLLATE )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==COLLATE) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:180:32: COLLATE
                    {
                    _last = (CommonTree)input.LT(1);
                    COLLATE117=(CommonTree)match(input,COLLATE,FOLLOW_COLLATE_in_sortSpecification725); 
                     
                    if ( _first_1==null ) _first_1 = COLLATE117;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }

            _last = (CommonTree)input.LT(1);
            ORDER_SPEC118=(CommonTree)match(input,ORDER_SPEC,FOLLOW_ORDER_SPEC_in_sortSpecification728); 
             
            if ( _first_1==null ) _first_1 = ORDER_SPEC118;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sortSpecification"

    public static class searchCondition_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "searchCondition"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:183:1: searchCondition : ( ^( OR searchCondition searchCondition ) | ^( AND searchCondition searchCondition ) | ^( NOT searchCondition ) | predicate );
    public final TestHQLTreeWalker.searchCondition_return searchCondition() throws RecognitionException {
        TestHQLTreeWalker.searchCondition_return retval = new TestHQLTreeWalker.searchCondition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR119=null;
        CommonTree AND122=null;
        CommonTree NOT125=null;
        TestHQLTreeWalker.searchCondition_return searchCondition120 = null;

        TestHQLTreeWalker.searchCondition_return searchCondition121 = null;

        TestHQLTreeWalker.searchCondition_return searchCondition123 = null;

        TestHQLTreeWalker.searchCondition_return searchCondition124 = null;

        TestHQLTreeWalker.searchCondition_return searchCondition126 = null;

        TestHQLTreeWalker.predicate_return predicate127 = null;


        CommonTree OR119_tree=null;
        CommonTree AND122_tree=null;
        CommonTree NOT125_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:184:2: ( ^( OR searchCondition searchCondition ) | ^( AND searchCondition searchCondition ) | ^( NOT searchCondition ) | predicate )
            int alt44=4;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt44=1;
                }
                break;
            case AND:
                {
                alt44=2;
                }
                break;
            case NOT:
                {
                alt44=3;
                }
                break;
            case ALIAS_REF:
            case DOT_CLASS:
            case IS_NOT_EMPTY:
            case IS_NOT_NULL:
            case IS_NULL:
            case JAVA_CONSTANT:
            case JPA_PARAM:
            case NAMED_PARAM:
            case NOT_BETWEEN:
            case NOT_IN:
            case NOT_LIKE:
            case NOT_MEMBER_OF:
            case PATH:
            case PROPERTY_REFERENCE:
            case SEARCHED_CASE:
            case SIMPLE_CASE:
            case SUB_QUERY:
            case UNARY_MINUS:
            case UNARY_PLUS:
            case VECTOR_EXPR:
            case ABS:
            case ALL:
            case ANY:
            case AVG:
            case BETWEEN:
            case BIT_LENGTH:
            case CAST:
            case CHARACTER_LENGTH:
            case COALESCE:
            case CONCAT:
            case COUNT:
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
            case ELEMENTS:
            case EXISTS:
            case EXTRACT:
            case IN:
            case INDEX:
            case INDICES:
            case IS_EMPTY:
            case LENGTH:
            case LIKE:
            case LOCATE:
            case LOWER:
            case MAX:
            case MAXELEMENT:
            case MAXINDEX:
            case MEMBER_OF:
            case MIN:
            case MINELEMENT:
            case MININDEX:
            case MOD:
            case NULLIF:
            case OCTET_LENGTH:
            case POSITION:
            case SIZE:
            case SOME:
            case SQRT:
            case SUBSTRING:
            case SUM:
            case TRIM:
            case UPPER:
            case HEX_LITERAL:
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
            case OCTAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case TRUE:
            case FALSE:
            case NULL:
            case EQUALS:
            case NOT_EQUAL:
            case DOUBLE_PIPE:
            case PARAM:
            case GREATER:
            case GREATER_EQUAL:
            case LESS:
            case LESS_EQUAL:
            case PLUS:
            case MINUS:
            case ASTERISK:
            case SOLIDUS:
            case GENERAL_FUNCTION_CALL:
                {
                alt44=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:184:4: ^( OR searchCondition searchCondition )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    OR119=(CommonTree)match(input,OR,FOLLOW_OR_in_searchCondition742); 


                    if ( _first_0==null ) _first_0 = OR119;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_searchCondition_in_searchCondition744);
                    searchCondition120=searchCondition();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = searchCondition120.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_searchCondition_in_searchCondition746);
                    searchCondition121=searchCondition();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = searchCondition121.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:185:4: ^( AND searchCondition searchCondition )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    AND122=(CommonTree)match(input,AND,FOLLOW_AND_in_searchCondition755); 


                    if ( _first_0==null ) _first_0 = AND122;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_searchCondition_in_searchCondition757);
                    searchCondition123=searchCondition();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = searchCondition123.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_searchCondition_in_searchCondition759);
                    searchCondition124=searchCondition();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = searchCondition124.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:186:4: ^( NOT searchCondition )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    NOT125=(CommonTree)match(input,NOT,FOLLOW_NOT_in_searchCondition768); 


                    if ( _first_0==null ) _first_0 = NOT125;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_searchCondition_in_searchCondition770);
                    searchCondition126=searchCondition();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = searchCondition126.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:187:4: predicate
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_predicate_in_searchCondition777);
                    predicate127=predicate();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = predicate127.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "searchCondition"

    public static class predicate_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "predicate"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:190:1: predicate : ( ^( EQUALS rowValueConstructor comparativePredicateValue ) | ^( NOT_EQUAL rowValueConstructor comparativePredicateValue ) | ^( LESS rowValueConstructor comparativePredicateValue ) | ^( LESS_EQUAL rowValueConstructor comparativePredicateValue ) | ^( GREATER rowValueConstructor comparativePredicateValue ) | ^( GREATER_EQUAL rowValueConstructor comparativePredicateValue ) | ^( IS_NULL rowValueConstructor ) | ^( IS_NOT_NULL rowValueConstructor ) | ^( LIKE valueExpression valueExpression ( escapeSpecification )? ) | ^( NOT_LIKE valueExpression valueExpression ( escapeSpecification )? ) | ^( BETWEEN rowValueConstructor betweenList ) | ^( NOT_BETWEEN rowValueConstructor betweenList ) | ^( IN rowValueConstructor inPredicateValue ) | ^( NOT_IN rowValueConstructor inPredicateValue ) | ^( MEMBER_OF rowValueConstructor rowValueConstructor ) | ^( NOT_MEMBER_OF rowValueConstructor rowValueConstructor ) | ^( IS_EMPTY rowValueConstructor ) | ^( IS_NOT_EMPTY rowValueConstructor ) | rowValueConstructor );
    public final TestHQLTreeWalker.predicate_return predicate() throws RecognitionException {
        TestHQLTreeWalker.predicate_return retval = new TestHQLTreeWalker.predicate_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EQUALS128=null;
        CommonTree NOT_EQUAL131=null;
        CommonTree LESS134=null;
        CommonTree LESS_EQUAL137=null;
        CommonTree GREATER140=null;
        CommonTree GREATER_EQUAL143=null;
        CommonTree IS_NULL146=null;
        CommonTree IS_NOT_NULL148=null;
        CommonTree LIKE150=null;
        CommonTree NOT_LIKE154=null;
        CommonTree BETWEEN158=null;
        CommonTree NOT_BETWEEN161=null;
        CommonTree IN164=null;
        CommonTree NOT_IN167=null;
        CommonTree MEMBER_OF170=null;
        CommonTree NOT_MEMBER_OF173=null;
        CommonTree IS_EMPTY176=null;
        CommonTree IS_NOT_EMPTY178=null;
        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor129 = null;

        TestHQLTreeWalker.comparativePredicateValue_return comparativePredicateValue130 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor132 = null;

        TestHQLTreeWalker.comparativePredicateValue_return comparativePredicateValue133 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor135 = null;

        TestHQLTreeWalker.comparativePredicateValue_return comparativePredicateValue136 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor138 = null;

        TestHQLTreeWalker.comparativePredicateValue_return comparativePredicateValue139 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor141 = null;

        TestHQLTreeWalker.comparativePredicateValue_return comparativePredicateValue142 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor144 = null;

        TestHQLTreeWalker.comparativePredicateValue_return comparativePredicateValue145 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor147 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor149 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression151 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression152 = null;

        TestHQLTreeWalker.escapeSpecification_return escapeSpecification153 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression155 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression156 = null;

        TestHQLTreeWalker.escapeSpecification_return escapeSpecification157 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor159 = null;

        TestHQLTreeWalker.betweenList_return betweenList160 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor162 = null;

        TestHQLTreeWalker.betweenList_return betweenList163 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor165 = null;

        TestHQLTreeWalker.inPredicateValue_return inPredicateValue166 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor168 = null;

        TestHQLTreeWalker.inPredicateValue_return inPredicateValue169 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor171 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor172 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor174 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor175 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor177 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor179 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor180 = null;


        CommonTree EQUALS128_tree=null;
        CommonTree NOT_EQUAL131_tree=null;
        CommonTree LESS134_tree=null;
        CommonTree LESS_EQUAL137_tree=null;
        CommonTree GREATER140_tree=null;
        CommonTree GREATER_EQUAL143_tree=null;
        CommonTree IS_NULL146_tree=null;
        CommonTree IS_NOT_NULL148_tree=null;
        CommonTree LIKE150_tree=null;
        CommonTree NOT_LIKE154_tree=null;
        CommonTree BETWEEN158_tree=null;
        CommonTree NOT_BETWEEN161_tree=null;
        CommonTree IN164_tree=null;
        CommonTree NOT_IN167_tree=null;
        CommonTree MEMBER_OF170_tree=null;
        CommonTree NOT_MEMBER_OF173_tree=null;
        CommonTree IS_EMPTY176_tree=null;
        CommonTree IS_NOT_EMPTY178_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:191:2: ( ^( EQUALS rowValueConstructor comparativePredicateValue ) | ^( NOT_EQUAL rowValueConstructor comparativePredicateValue ) | ^( LESS rowValueConstructor comparativePredicateValue ) | ^( LESS_EQUAL rowValueConstructor comparativePredicateValue ) | ^( GREATER rowValueConstructor comparativePredicateValue ) | ^( GREATER_EQUAL rowValueConstructor comparativePredicateValue ) | ^( IS_NULL rowValueConstructor ) | ^( IS_NOT_NULL rowValueConstructor ) | ^( LIKE valueExpression valueExpression ( escapeSpecification )? ) | ^( NOT_LIKE valueExpression valueExpression ( escapeSpecification )? ) | ^( BETWEEN rowValueConstructor betweenList ) | ^( NOT_BETWEEN rowValueConstructor betweenList ) | ^( IN rowValueConstructor inPredicateValue ) | ^( NOT_IN rowValueConstructor inPredicateValue ) | ^( MEMBER_OF rowValueConstructor rowValueConstructor ) | ^( NOT_MEMBER_OF rowValueConstructor rowValueConstructor ) | ^( IS_EMPTY rowValueConstructor ) | ^( IS_NOT_EMPTY rowValueConstructor ) | rowValueConstructor )
            int alt47=19;
            switch ( input.LA(1) ) {
            case EQUALS:
                {
                alt47=1;
                }
                break;
            case NOT_EQUAL:
                {
                alt47=2;
                }
                break;
            case LESS:
                {
                alt47=3;
                }
                break;
            case LESS_EQUAL:
                {
                alt47=4;
                }
                break;
            case GREATER:
                {
                alt47=5;
                }
                break;
            case GREATER_EQUAL:
                {
                alt47=6;
                }
                break;
            case IS_NULL:
                {
                alt47=7;
                }
                break;
            case IS_NOT_NULL:
                {
                alt47=8;
                }
                break;
            case LIKE:
                {
                alt47=9;
                }
                break;
            case NOT_LIKE:
                {
                alt47=10;
                }
                break;
            case BETWEEN:
                {
                alt47=11;
                }
                break;
            case NOT_BETWEEN:
                {
                alt47=12;
                }
                break;
            case IN:
                {
                alt47=13;
                }
                break;
            case NOT_IN:
                {
                alt47=14;
                }
                break;
            case MEMBER_OF:
                {
                alt47=15;
                }
                break;
            case NOT_MEMBER_OF:
                {
                alt47=16;
                }
                break;
            case IS_EMPTY:
                {
                alt47=17;
                }
                break;
            case IS_NOT_EMPTY:
                {
                alt47=18;
                }
                break;
            case ALIAS_REF:
            case DOT_CLASS:
            case JAVA_CONSTANT:
            case JPA_PARAM:
            case NAMED_PARAM:
            case PATH:
            case PROPERTY_REFERENCE:
            case SEARCHED_CASE:
            case SIMPLE_CASE:
            case SUB_QUERY:
            case UNARY_MINUS:
            case UNARY_PLUS:
            case VECTOR_EXPR:
            case ABS:
            case ALL:
            case ANY:
            case AVG:
            case BIT_LENGTH:
            case CAST:
            case CHARACTER_LENGTH:
            case COALESCE:
            case CONCAT:
            case COUNT:
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
            case ELEMENTS:
            case EXISTS:
            case EXTRACT:
            case INDEX:
            case INDICES:
            case LENGTH:
            case LOCATE:
            case LOWER:
            case MAX:
            case MAXELEMENT:
            case MAXINDEX:
            case MIN:
            case MINELEMENT:
            case MININDEX:
            case MOD:
            case NULLIF:
            case OCTET_LENGTH:
            case POSITION:
            case SIZE:
            case SOME:
            case SQRT:
            case SUBSTRING:
            case SUM:
            case TRIM:
            case UPPER:
            case HEX_LITERAL:
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
            case OCTAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case TRUE:
            case FALSE:
            case NULL:
            case DOUBLE_PIPE:
            case PARAM:
            case PLUS:
            case MINUS:
            case ASTERISK:
            case SOLIDUS:
            case GENERAL_FUNCTION_CALL:
                {
                alt47=19;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:191:4: ^( EQUALS rowValueConstructor comparativePredicateValue )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    EQUALS128=(CommonTree)match(input,EQUALS,FOLLOW_EQUALS_in_predicate790); 


                    if ( _first_0==null ) _first_0 = EQUALS128;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate792);
                    rowValueConstructor129=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor129.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comparativePredicateValue_in_predicate794);
                    comparativePredicateValue130=comparativePredicateValue();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = comparativePredicateValue130.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:192:4: ^( NOT_EQUAL rowValueConstructor comparativePredicateValue )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    NOT_EQUAL131=(CommonTree)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_predicate803); 


                    if ( _first_0==null ) _first_0 = NOT_EQUAL131;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate805);
                    rowValueConstructor132=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor132.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comparativePredicateValue_in_predicate807);
                    comparativePredicateValue133=comparativePredicateValue();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = comparativePredicateValue133.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:193:4: ^( LESS rowValueConstructor comparativePredicateValue )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    LESS134=(CommonTree)match(input,LESS,FOLLOW_LESS_in_predicate816); 


                    if ( _first_0==null ) _first_0 = LESS134;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate818);
                    rowValueConstructor135=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor135.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comparativePredicateValue_in_predicate820);
                    comparativePredicateValue136=comparativePredicateValue();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = comparativePredicateValue136.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:194:4: ^( LESS_EQUAL rowValueConstructor comparativePredicateValue )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    LESS_EQUAL137=(CommonTree)match(input,LESS_EQUAL,FOLLOW_LESS_EQUAL_in_predicate829); 


                    if ( _first_0==null ) _first_0 = LESS_EQUAL137;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate831);
                    rowValueConstructor138=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor138.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comparativePredicateValue_in_predicate833);
                    comparativePredicateValue139=comparativePredicateValue();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = comparativePredicateValue139.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 5 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:195:4: ^( GREATER rowValueConstructor comparativePredicateValue )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    GREATER140=(CommonTree)match(input,GREATER,FOLLOW_GREATER_in_predicate842); 


                    if ( _first_0==null ) _first_0 = GREATER140;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate844);
                    rowValueConstructor141=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor141.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comparativePredicateValue_in_predicate846);
                    comparativePredicateValue142=comparativePredicateValue();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = comparativePredicateValue142.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 6 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:196:4: ^( GREATER_EQUAL rowValueConstructor comparativePredicateValue )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    GREATER_EQUAL143=(CommonTree)match(input,GREATER_EQUAL,FOLLOW_GREATER_EQUAL_in_predicate855); 


                    if ( _first_0==null ) _first_0 = GREATER_EQUAL143;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate857);
                    rowValueConstructor144=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor144.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comparativePredicateValue_in_predicate859);
                    comparativePredicateValue145=comparativePredicateValue();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = comparativePredicateValue145.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 7 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:197:4: ^( IS_NULL rowValueConstructor )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    IS_NULL146=(CommonTree)match(input,IS_NULL,FOLLOW_IS_NULL_in_predicate868); 


                    if ( _first_0==null ) _first_0 = IS_NULL146;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate870);
                    rowValueConstructor147=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor147.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 8 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:198:4: ^( IS_NOT_NULL rowValueConstructor )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    IS_NOT_NULL148=(CommonTree)match(input,IS_NOT_NULL,FOLLOW_IS_NOT_NULL_in_predicate879); 


                    if ( _first_0==null ) _first_0 = IS_NOT_NULL148;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate881);
                    rowValueConstructor149=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor149.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 9 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:199:4: ^( LIKE valueExpression valueExpression ( escapeSpecification )? )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    LIKE150=(CommonTree)match(input,LIKE,FOLLOW_LIKE_in_predicate890); 


                    if ( _first_0==null ) _first_0 = LIKE150;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_predicate892);
                    valueExpression151=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression151.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_predicate894);
                    valueExpression152=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression152.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:199:44: ( escapeSpecification )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==ESCAPE) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:199:44: escapeSpecification
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_escapeSpecification_in_predicate896);
                            escapeSpecification153=escapeSpecification();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = escapeSpecification153.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 10 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:200:4: ^( NOT_LIKE valueExpression valueExpression ( escapeSpecification )? )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    NOT_LIKE154=(CommonTree)match(input,NOT_LIKE,FOLLOW_NOT_LIKE_in_predicate906); 


                    if ( _first_0==null ) _first_0 = NOT_LIKE154;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_predicate908);
                    valueExpression155=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression155.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_predicate910);
                    valueExpression156=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression156.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:200:48: ( escapeSpecification )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==ESCAPE) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:200:48: escapeSpecification
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_escapeSpecification_in_predicate912);
                            escapeSpecification157=escapeSpecification();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = escapeSpecification157.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 11 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:201:4: ^( BETWEEN rowValueConstructor betweenList )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    BETWEEN158=(CommonTree)match(input,BETWEEN,FOLLOW_BETWEEN_in_predicate922); 


                    if ( _first_0==null ) _first_0 = BETWEEN158;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate924);
                    rowValueConstructor159=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor159.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_betweenList_in_predicate926);
                    betweenList160=betweenList();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = betweenList160.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 12 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:202:4: ^( NOT_BETWEEN rowValueConstructor betweenList )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    NOT_BETWEEN161=(CommonTree)match(input,NOT_BETWEEN,FOLLOW_NOT_BETWEEN_in_predicate935); 


                    if ( _first_0==null ) _first_0 = NOT_BETWEEN161;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate937);
                    rowValueConstructor162=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor162.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_betweenList_in_predicate939);
                    betweenList163=betweenList();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = betweenList163.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 13 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:203:4: ^( IN rowValueConstructor inPredicateValue )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    IN164=(CommonTree)match(input,IN,FOLLOW_IN_in_predicate948); 


                    if ( _first_0==null ) _first_0 = IN164;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate950);
                    rowValueConstructor165=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor165.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inPredicateValue_in_predicate952);
                    inPredicateValue166=inPredicateValue();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = inPredicateValue166.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 14 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:204:4: ^( NOT_IN rowValueConstructor inPredicateValue )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    NOT_IN167=(CommonTree)match(input,NOT_IN,FOLLOW_NOT_IN_in_predicate961); 


                    if ( _first_0==null ) _first_0 = NOT_IN167;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate963);
                    rowValueConstructor168=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor168.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inPredicateValue_in_predicate965);
                    inPredicateValue169=inPredicateValue();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = inPredicateValue169.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 15 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:205:4: ^( MEMBER_OF rowValueConstructor rowValueConstructor )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    MEMBER_OF170=(CommonTree)match(input,MEMBER_OF,FOLLOW_MEMBER_OF_in_predicate974); 


                    if ( _first_0==null ) _first_0 = MEMBER_OF170;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate976);
                    rowValueConstructor171=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor171.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate978);
                    rowValueConstructor172=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor172.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 16 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:206:4: ^( NOT_MEMBER_OF rowValueConstructor rowValueConstructor )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    NOT_MEMBER_OF173=(CommonTree)match(input,NOT_MEMBER_OF,FOLLOW_NOT_MEMBER_OF_in_predicate987); 


                    if ( _first_0==null ) _first_0 = NOT_MEMBER_OF173;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate989);
                    rowValueConstructor174=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor174.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate991);
                    rowValueConstructor175=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor175.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 17 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:207:4: ^( IS_EMPTY rowValueConstructor )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    IS_EMPTY176=(CommonTree)match(input,IS_EMPTY,FOLLOW_IS_EMPTY_in_predicate1001); 


                    if ( _first_0==null ) _first_0 = IS_EMPTY176;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate1003);
                    rowValueConstructor177=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor177.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 18 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:208:4: ^( IS_NOT_EMPTY rowValueConstructor )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    IS_NOT_EMPTY178=(CommonTree)match(input,IS_NOT_EMPTY,FOLLOW_IS_NOT_EMPTY_in_predicate1012); 


                    if ( _first_0==null ) _first_0 = IS_NOT_EMPTY178;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate1014);
                    rowValueConstructor179=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor179.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 19 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:209:4: rowValueConstructor
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_predicate1021);
                    rowValueConstructor180=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = rowValueConstructor180.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "predicate"

    public static class betweenList_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "betweenList"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:212:1: betweenList : ^( BETWEEN_LIST rowValueConstructor rowValueConstructor ) ;
    public final TestHQLTreeWalker.betweenList_return betweenList() throws RecognitionException {
        TestHQLTreeWalker.betweenList_return retval = new TestHQLTreeWalker.betweenList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BETWEEN_LIST181=null;
        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor182 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor183 = null;


        CommonTree BETWEEN_LIST181_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:213:2: ( ^( BETWEEN_LIST rowValueConstructor rowValueConstructor ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:213:4: ^( BETWEEN_LIST rowValueConstructor rowValueConstructor )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            BETWEEN_LIST181=(CommonTree)match(input,BETWEEN_LIST,FOLLOW_BETWEEN_LIST_in_betweenList1034); 


            if ( _first_0==null ) _first_0 = BETWEEN_LIST181;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rowValueConstructor_in_betweenList1036);
            rowValueConstructor182=rowValueConstructor();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = rowValueConstructor182.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rowValueConstructor_in_betweenList1038);
            rowValueConstructor183=rowValueConstructor();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = rowValueConstructor183.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "betweenList"

    public static class comparativePredicateValue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparativePredicateValue"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:216:1: comparativePredicateValue : rowValueConstructor ;
    public final TestHQLTreeWalker.comparativePredicateValue_return comparativePredicateValue() throws RecognitionException {
        TestHQLTreeWalker.comparativePredicateValue_return retval = new TestHQLTreeWalker.comparativePredicateValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor184 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:217:2: ( rowValueConstructor )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:217:4: rowValueConstructor
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rowValueConstructor_in_comparativePredicateValue1052);
            rowValueConstructor184=rowValueConstructor();

            state._fsp--;

             
            if ( _first_0==null ) _first_0 = rowValueConstructor184.tree;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparativePredicateValue"

    public static class rowValueConstructor_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rowValueConstructor"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:220:1: rowValueConstructor : valueExpression ;
    public final TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor() throws RecognitionException {
        TestHQLTreeWalker.rowValueConstructor_return retval = new TestHQLTreeWalker.rowValueConstructor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.valueExpression_return valueExpression185 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:221:2: ( valueExpression )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:221:4: valueExpression
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_rowValueConstructor1063);
            valueExpression185=valueExpression();

            state._fsp--;

             
            if ( _first_0==null ) _first_0 = valueExpression185.tree;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rowValueConstructor"

    public static class escapeSpecification_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "escapeSpecification"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:224:1: escapeSpecification : ^( ESCAPE characterValueExpression ) ;
    public final TestHQLTreeWalker.escapeSpecification_return escapeSpecification() throws RecognitionException {
        TestHQLTreeWalker.escapeSpecification_return retval = new TestHQLTreeWalker.escapeSpecification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ESCAPE186=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression187 = null;


        CommonTree ESCAPE186_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:225:2: ( ^( ESCAPE characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:225:4: ^( ESCAPE characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            ESCAPE186=(CommonTree)match(input,ESCAPE,FOLLOW_ESCAPE_in_escapeSpecification1075); 


            if ( _first_0==null ) _first_0 = ESCAPE186;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_escapeSpecification1077);
            characterValueExpression187=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression187.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "escapeSpecification"

    public static class inPredicateValue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inPredicateValue"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:228:1: inPredicateValue : ^( IN_LIST ( valueExpression )+ ) ;
    public final TestHQLTreeWalker.inPredicateValue_return inPredicateValue() throws RecognitionException {
        TestHQLTreeWalker.inPredicateValue_return retval = new TestHQLTreeWalker.inPredicateValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN_LIST188=null;
        TestHQLTreeWalker.valueExpression_return valueExpression189 = null;


        CommonTree IN_LIST188_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:229:2: ( ^( IN_LIST ( valueExpression )+ ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:229:4: ^( IN_LIST ( valueExpression )+ )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            IN_LIST188=(CommonTree)match(input,IN_LIST,FOLLOW_IN_LIST_in_inPredicateValue1090); 


            if ( _first_0==null ) _first_0 = IN_LIST188;
            match(input, Token.DOWN, null); 
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:229:14: ( valueExpression )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==ALIAS_REF||LA48_0==DOT_CLASS||(LA48_0>=JAVA_CONSTANT && LA48_0<=NAMED_PARAM)||LA48_0==PATH||LA48_0==PROPERTY_REFERENCE||LA48_0==SEARCHED_CASE||LA48_0==SIMPLE_CASE||(LA48_0>=SUB_QUERY && LA48_0<=VECTOR_EXPR)||(LA48_0>=ABS && LA48_0<=ALL)||LA48_0==ANY||LA48_0==AVG||LA48_0==BIT_LENGTH||(LA48_0>=CAST && LA48_0<=CHARACTER_LENGTH)||(LA48_0>=COALESCE && LA48_0<=COUNT)||(LA48_0>=CURRENT_DATE && LA48_0<=CURRENT_TIMESTAMP)||LA48_0==ELEMENTS||(LA48_0>=EXISTS && LA48_0<=EXTRACT)||(LA48_0>=INDEX && LA48_0<=INDICES)||LA48_0==LENGTH||(LA48_0>=LOCATE && LA48_0<=MAXINDEX)||(LA48_0>=MIN && LA48_0<=MININDEX)||LA48_0==MOD||(LA48_0>=NULLIF && LA48_0<=OCTET_LENGTH)||LA48_0==POSITION||(LA48_0>=SIZE && LA48_0<=SUM)||LA48_0==TRIM||LA48_0==UPPER||(LA48_0>=HEX_LITERAL && LA48_0<=OCTAL_LITERAL)||LA48_0==FLOATING_POINT_LITERAL||(LA48_0>=CHARACTER_LITERAL && LA48_0<=STRING_LITERAL)||(LA48_0>=TRUE && LA48_0<=NULL)||(LA48_0>=DOUBLE_PIPE && LA48_0<=PARAM)||(LA48_0>=PLUS && LA48_0<=SOLIDUS)||LA48_0==GENERAL_FUNCTION_CALL) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:229:14: valueExpression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_valueExpression_in_inPredicateValue1092);
            	    valueExpression189=valueExpression();

            	    state._fsp--;

            	     
            	    if ( _first_1==null ) _first_1 = valueExpression189.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inPredicateValue"

    public static class numericValueExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numericValueExpression"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:232:1: numericValueExpression : valueExpression ;
    public final TestHQLTreeWalker.numericValueExpression_return numericValueExpression() throws RecognitionException {
        TestHQLTreeWalker.numericValueExpression_return retval = new TestHQLTreeWalker.numericValueExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.valueExpression_return valueExpression190 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:233:2: ( valueExpression )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:233:4: valueExpression
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_numericValueExpression1105);
            valueExpression190=valueExpression();

            state._fsp--;

             
            if ( _first_0==null ) _first_0 = valueExpression190.tree;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "numericValueExpression"

    public static class characterValueExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "characterValueExpression"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:236:1: characterValueExpression : valueExpression ;
    public final TestHQLTreeWalker.characterValueExpression_return characterValueExpression() throws RecognitionException {
        TestHQLTreeWalker.characterValueExpression_return retval = new TestHQLTreeWalker.characterValueExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.valueExpression_return valueExpression191 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:237:2: ( valueExpression )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:237:4: valueExpression
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_characterValueExpression1116);
            valueExpression191=valueExpression();

            state._fsp--;

             
            if ( _first_0==null ) _first_0 = valueExpression191.tree;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "characterValueExpression"

    public static class datetimeValueExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "datetimeValueExpression"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:240:1: datetimeValueExpression : valueExpression ;
    public final TestHQLTreeWalker.datetimeValueExpression_return datetimeValueExpression() throws RecognitionException {
        TestHQLTreeWalker.datetimeValueExpression_return retval = new TestHQLTreeWalker.datetimeValueExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.valueExpression_return valueExpression192 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:241:2: ( valueExpression )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:241:4: valueExpression
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_datetimeValueExpression1127);
            valueExpression192=valueExpression();

            state._fsp--;

             
            if ( _first_0==null ) _first_0 = valueExpression192.tree;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "datetimeValueExpression"

    public static class valueExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "valueExpression"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:244:1: valueExpression : ( ^( DOUBLE_PIPE ( characterValueExpression )+ ) | ^( UNARY_MINUS numericValueExpression ) | ^( UNARY_PLUS numericValueExpression ) | ^( PLUS valueExpression valueExpression ) | ^( MINUS valueExpression valueExpression ) | ^( ASTERISK numericValueExpression numericValueExpression ) | ^( SOLIDUS numericValueExpression numericValueExpression ) | ^( EXISTS rowValueConstructor ) | ^( SOME valueExpression ) | ^( ALL valueExpression ) | ^( ANY valueExpression ) | ^( VECTOR_EXPR ( valueExpression )+ ) | valueExpressionPrimary );
    public final TestHQLTreeWalker.valueExpression_return valueExpression() throws RecognitionException {
        TestHQLTreeWalker.valueExpression_return retval = new TestHQLTreeWalker.valueExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOUBLE_PIPE193=null;
        CommonTree UNARY_MINUS195=null;
        CommonTree UNARY_PLUS197=null;
        CommonTree PLUS199=null;
        CommonTree MINUS202=null;
        CommonTree ASTERISK205=null;
        CommonTree SOLIDUS208=null;
        CommonTree EXISTS211=null;
        CommonTree SOME213=null;
        CommonTree ALL215=null;
        CommonTree ANY217=null;
        CommonTree VECTOR_EXPR219=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression194 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression196 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression198 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression200 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression201 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression203 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression204 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression206 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression207 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression209 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression210 = null;

        TestHQLTreeWalker.rowValueConstructor_return rowValueConstructor212 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression214 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression216 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression218 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression220 = null;

        TestHQLTreeWalker.valueExpressionPrimary_return valueExpressionPrimary221 = null;


        CommonTree DOUBLE_PIPE193_tree=null;
        CommonTree UNARY_MINUS195_tree=null;
        CommonTree UNARY_PLUS197_tree=null;
        CommonTree PLUS199_tree=null;
        CommonTree MINUS202_tree=null;
        CommonTree ASTERISK205_tree=null;
        CommonTree SOLIDUS208_tree=null;
        CommonTree EXISTS211_tree=null;
        CommonTree SOME213_tree=null;
        CommonTree ALL215_tree=null;
        CommonTree ANY217_tree=null;
        CommonTree VECTOR_EXPR219_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:245:2: ( ^( DOUBLE_PIPE ( characterValueExpression )+ ) | ^( UNARY_MINUS numericValueExpression ) | ^( UNARY_PLUS numericValueExpression ) | ^( PLUS valueExpression valueExpression ) | ^( MINUS valueExpression valueExpression ) | ^( ASTERISK numericValueExpression numericValueExpression ) | ^( SOLIDUS numericValueExpression numericValueExpression ) | ^( EXISTS rowValueConstructor ) | ^( SOME valueExpression ) | ^( ALL valueExpression ) | ^( ANY valueExpression ) | ^( VECTOR_EXPR ( valueExpression )+ ) | valueExpressionPrimary )
            int alt51=13;
            switch ( input.LA(1) ) {
            case DOUBLE_PIPE:
                {
                alt51=1;
                }
                break;
            case UNARY_MINUS:
                {
                alt51=2;
                }
                break;
            case UNARY_PLUS:
                {
                alt51=3;
                }
                break;
            case PLUS:
                {
                alt51=4;
                }
                break;
            case MINUS:
                {
                alt51=5;
                }
                break;
            case ASTERISK:
                {
                alt51=6;
                }
                break;
            case SOLIDUS:
                {
                alt51=7;
                }
                break;
            case EXISTS:
                {
                alt51=8;
                }
                break;
            case SOME:
                {
                alt51=9;
                }
                break;
            case ALL:
                {
                alt51=10;
                }
                break;
            case ANY:
                {
                alt51=11;
                }
                break;
            case VECTOR_EXPR:
                {
                alt51=12;
                }
                break;
            case ALIAS_REF:
            case DOT_CLASS:
            case JAVA_CONSTANT:
            case JPA_PARAM:
            case NAMED_PARAM:
            case PATH:
            case PROPERTY_REFERENCE:
            case SEARCHED_CASE:
            case SIMPLE_CASE:
            case SUB_QUERY:
            case ABS:
            case AVG:
            case BIT_LENGTH:
            case CAST:
            case CHARACTER_LENGTH:
            case COALESCE:
            case CONCAT:
            case COUNT:
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
            case ELEMENTS:
            case EXTRACT:
            case INDEX:
            case INDICES:
            case LENGTH:
            case LOCATE:
            case LOWER:
            case MAX:
            case MAXELEMENT:
            case MAXINDEX:
            case MIN:
            case MINELEMENT:
            case MININDEX:
            case MOD:
            case NULLIF:
            case OCTET_LENGTH:
            case POSITION:
            case SIZE:
            case SQRT:
            case SUBSTRING:
            case SUM:
            case TRIM:
            case UPPER:
            case HEX_LITERAL:
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
            case OCTAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case TRUE:
            case FALSE:
            case NULL:
            case PARAM:
            case GENERAL_FUNCTION_CALL:
                {
                alt51=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:245:4: ^( DOUBLE_PIPE ( characterValueExpression )+ )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    DOUBLE_PIPE193=(CommonTree)match(input,DOUBLE_PIPE,FOLLOW_DOUBLE_PIPE_in_valueExpression1140); 


                    if ( _first_0==null ) _first_0 = DOUBLE_PIPE193;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:245:19: ( characterValueExpression )+
                    int cnt49=0;
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==ALIAS_REF||LA49_0==DOT_CLASS||(LA49_0>=JAVA_CONSTANT && LA49_0<=NAMED_PARAM)||LA49_0==PATH||LA49_0==PROPERTY_REFERENCE||LA49_0==SEARCHED_CASE||LA49_0==SIMPLE_CASE||(LA49_0>=SUB_QUERY && LA49_0<=VECTOR_EXPR)||(LA49_0>=ABS && LA49_0<=ALL)||LA49_0==ANY||LA49_0==AVG||LA49_0==BIT_LENGTH||(LA49_0>=CAST && LA49_0<=CHARACTER_LENGTH)||(LA49_0>=COALESCE && LA49_0<=COUNT)||(LA49_0>=CURRENT_DATE && LA49_0<=CURRENT_TIMESTAMP)||LA49_0==ELEMENTS||(LA49_0>=EXISTS && LA49_0<=EXTRACT)||(LA49_0>=INDEX && LA49_0<=INDICES)||LA49_0==LENGTH||(LA49_0>=LOCATE && LA49_0<=MAXINDEX)||(LA49_0>=MIN && LA49_0<=MININDEX)||LA49_0==MOD||(LA49_0>=NULLIF && LA49_0<=OCTET_LENGTH)||LA49_0==POSITION||(LA49_0>=SIZE && LA49_0<=SUM)||LA49_0==TRIM||LA49_0==UPPER||(LA49_0>=HEX_LITERAL && LA49_0<=OCTAL_LITERAL)||LA49_0==FLOATING_POINT_LITERAL||(LA49_0>=CHARACTER_LITERAL && LA49_0<=STRING_LITERAL)||(LA49_0>=TRUE && LA49_0<=NULL)||(LA49_0>=DOUBLE_PIPE && LA49_0<=PARAM)||(LA49_0>=PLUS && LA49_0<=SOLIDUS)||LA49_0==GENERAL_FUNCTION_CALL) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:245:19: characterValueExpression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_characterValueExpression_in_valueExpression1142);
                    	    characterValueExpression194=characterValueExpression();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = characterValueExpression194.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt49 >= 1 ) break loop49;
                                EarlyExitException eee =
                                    new EarlyExitException(49, input);
                                throw eee;
                        }
                        cnt49++;
                    } while (true);


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:246:4: ^( UNARY_MINUS numericValueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    UNARY_MINUS195=(CommonTree)match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_valueExpression1152); 


                    if ( _first_0==null ) _first_0 = UNARY_MINUS195;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_valueExpression1154);
                    numericValueExpression196=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression196.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:247:4: ^( UNARY_PLUS numericValueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    UNARY_PLUS197=(CommonTree)match(input,UNARY_PLUS,FOLLOW_UNARY_PLUS_in_valueExpression1163); 


                    if ( _first_0==null ) _first_0 = UNARY_PLUS197;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_valueExpression1165);
                    numericValueExpression198=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression198.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:248:4: ^( PLUS valueExpression valueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    PLUS199=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_valueExpression1174); 


                    if ( _first_0==null ) _first_0 = PLUS199;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_valueExpression1176);
                    valueExpression200=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression200.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_valueExpression1178);
                    valueExpression201=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression201.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 5 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:249:4: ^( MINUS valueExpression valueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    MINUS202=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_valueExpression1187); 


                    if ( _first_0==null ) _first_0 = MINUS202;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_valueExpression1189);
                    valueExpression203=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression203.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_valueExpression1191);
                    valueExpression204=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression204.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 6 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:250:4: ^( ASTERISK numericValueExpression numericValueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    ASTERISK205=(CommonTree)match(input,ASTERISK,FOLLOW_ASTERISK_in_valueExpression1200); 


                    if ( _first_0==null ) _first_0 = ASTERISK205;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_valueExpression1202);
                    numericValueExpression206=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression206.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_valueExpression1204);
                    numericValueExpression207=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression207.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 7 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:251:4: ^( SOLIDUS numericValueExpression numericValueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    SOLIDUS208=(CommonTree)match(input,SOLIDUS,FOLLOW_SOLIDUS_in_valueExpression1213); 


                    if ( _first_0==null ) _first_0 = SOLIDUS208;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_valueExpression1215);
                    numericValueExpression209=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression209.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_valueExpression1217);
                    numericValueExpression210=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression210.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 8 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:252:4: ^( EXISTS rowValueConstructor )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    EXISTS211=(CommonTree)match(input,EXISTS,FOLLOW_EXISTS_in_valueExpression1226); 


                    if ( _first_0==null ) _first_0 = EXISTS211;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rowValueConstructor_in_valueExpression1228);
                    rowValueConstructor212=rowValueConstructor();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = rowValueConstructor212.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 9 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:253:7: ^( SOME valueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    SOME213=(CommonTree)match(input,SOME,FOLLOW_SOME_in_valueExpression1239); 


                    if ( _first_0==null ) _first_0 = SOME213;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_valueExpression1241);
                    valueExpression214=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression214.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 10 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:254:7: ^( ALL valueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    ALL215=(CommonTree)match(input,ALL,FOLLOW_ALL_in_valueExpression1253); 


                    if ( _first_0==null ) _first_0 = ALL215;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_valueExpression1255);
                    valueExpression216=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression216.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 11 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:255:7: ^( ANY valueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    ANY217=(CommonTree)match(input,ANY,FOLLOW_ANY_in_valueExpression1267); 


                    if ( _first_0==null ) _first_0 = ANY217;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_valueExpression1269);
                    valueExpression218=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression218.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 12 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:256:4: ^( VECTOR_EXPR ( valueExpression )+ )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    VECTOR_EXPR219=(CommonTree)match(input,VECTOR_EXPR,FOLLOW_VECTOR_EXPR_in_valueExpression1278); 


                    if ( _first_0==null ) _first_0 = VECTOR_EXPR219;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:256:19: ( valueExpression )+
                    int cnt50=0;
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==ALIAS_REF||LA50_0==DOT_CLASS||(LA50_0>=JAVA_CONSTANT && LA50_0<=NAMED_PARAM)||LA50_0==PATH||LA50_0==PROPERTY_REFERENCE||LA50_0==SEARCHED_CASE||LA50_0==SIMPLE_CASE||(LA50_0>=SUB_QUERY && LA50_0<=VECTOR_EXPR)||(LA50_0>=ABS && LA50_0<=ALL)||LA50_0==ANY||LA50_0==AVG||LA50_0==BIT_LENGTH||(LA50_0>=CAST && LA50_0<=CHARACTER_LENGTH)||(LA50_0>=COALESCE && LA50_0<=COUNT)||(LA50_0>=CURRENT_DATE && LA50_0<=CURRENT_TIMESTAMP)||LA50_0==ELEMENTS||(LA50_0>=EXISTS && LA50_0<=EXTRACT)||(LA50_0>=INDEX && LA50_0<=INDICES)||LA50_0==LENGTH||(LA50_0>=LOCATE && LA50_0<=MAXINDEX)||(LA50_0>=MIN && LA50_0<=MININDEX)||LA50_0==MOD||(LA50_0>=NULLIF && LA50_0<=OCTET_LENGTH)||LA50_0==POSITION||(LA50_0>=SIZE && LA50_0<=SUM)||LA50_0==TRIM||LA50_0==UPPER||(LA50_0>=HEX_LITERAL && LA50_0<=OCTAL_LITERAL)||LA50_0==FLOATING_POINT_LITERAL||(LA50_0>=CHARACTER_LITERAL && LA50_0<=STRING_LITERAL)||(LA50_0>=TRUE && LA50_0<=NULL)||(LA50_0>=DOUBLE_PIPE && LA50_0<=PARAM)||(LA50_0>=PLUS && LA50_0<=SOLIDUS)||LA50_0==GENERAL_FUNCTION_CALL) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:256:19: valueExpression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_valueExpression_in_valueExpression1280);
                    	    valueExpression220=valueExpression();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = valueExpression220.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt50 >= 1 ) break loop50;
                                EarlyExitException eee =
                                    new EarlyExitException(50, input);
                                throw eee;
                        }
                        cnt50++;
                    } while (true);


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 13 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:257:4: valueExpressionPrimary
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpressionPrimary_in_valueExpression1288);
                    valueExpressionPrimary221=valueExpressionPrimary();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = valueExpressionPrimary221.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "valueExpression"

    public static class valueExpressionPrimary_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "valueExpressionPrimary"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:260:1: valueExpressionPrimary : ( caseExpression | function | collectionFunction | collectionExpression | constant | parameter | propertyReference | ^( SUB_QUERY queryStatementSet ) | ALIAS_REF | ^( DOT_CLASS identPrimary ) | ^( GENERAL_FUNCTION_CALL identPrimary ) | ^( JAVA_CONSTANT identPrimary ) | ^( PATH identPrimary ) );
    public final TestHQLTreeWalker.valueExpressionPrimary_return valueExpressionPrimary() throws RecognitionException {
        TestHQLTreeWalker.valueExpressionPrimary_return retval = new TestHQLTreeWalker.valueExpressionPrimary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SUB_QUERY229=null;
        CommonTree ALIAS_REF231=null;
        CommonTree DOT_CLASS232=null;
        CommonTree GENERAL_FUNCTION_CALL234=null;
        CommonTree JAVA_CONSTANT236=null;
        CommonTree PATH238=null;
        TestHQLTreeWalker.caseExpression_return caseExpression222 = null;

        TestHQLTreeWalker.function_return function223 = null;

        TestHQLTreeWalker.collectionFunction_return collectionFunction224 = null;

        TestHQLTreeWalker.collectionExpression_return collectionExpression225 = null;

        TestHQLTreeWalker.constant_return constant226 = null;

        TestHQLTreeWalker.parameter_return parameter227 = null;

        TestHQLTreeWalker.propertyReference_return propertyReference228 = null;

        TestHQLTreeWalker.queryStatementSet_return queryStatementSet230 = null;

        TestHQLTreeWalker.identPrimary_return identPrimary233 = null;

        TestHQLTreeWalker.identPrimary_return identPrimary235 = null;

        TestHQLTreeWalker.identPrimary_return identPrimary237 = null;

        TestHQLTreeWalker.identPrimary_return identPrimary239 = null;


        CommonTree SUB_QUERY229_tree=null;
        CommonTree ALIAS_REF231_tree=null;
        CommonTree DOT_CLASS232_tree=null;
        CommonTree GENERAL_FUNCTION_CALL234_tree=null;
        CommonTree JAVA_CONSTANT236_tree=null;
        CommonTree PATH238_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:261:2: ( caseExpression | function | collectionFunction | collectionExpression | constant | parameter | propertyReference | ^( SUB_QUERY queryStatementSet ) | ALIAS_REF | ^( DOT_CLASS identPrimary ) | ^( GENERAL_FUNCTION_CALL identPrimary ) | ^( JAVA_CONSTANT identPrimary ) | ^( PATH identPrimary ) )
            int alt52=13;
            switch ( input.LA(1) ) {
            case SEARCHED_CASE:
            case SIMPLE_CASE:
            case COALESCE:
            case NULLIF:
                {
                alt52=1;
                }
                break;
            case ABS:
            case AVG:
            case BIT_LENGTH:
            case CAST:
            case CHARACTER_LENGTH:
            case CONCAT:
            case COUNT:
            case CURRENT_DATE:
            case CURRENT_TIME:
            case CURRENT_TIMESTAMP:
            case EXTRACT:
            case INDEX:
            case LENGTH:
            case LOCATE:
            case LOWER:
            case MAX:
            case MIN:
            case MOD:
            case OCTET_LENGTH:
            case POSITION:
            case SIZE:
            case SQRT:
            case SUBSTRING:
            case SUM:
            case TRIM:
            case UPPER:
                {
                alt52=2;
                }
                break;
            case MAXELEMENT:
            case MAXINDEX:
            case MINELEMENT:
            case MININDEX:
                {
                alt52=3;
                }
                break;
            case ELEMENTS:
            case INDICES:
                {
                alt52=4;
                }
                break;
            case HEX_LITERAL:
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
            case OCTAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case TRUE:
            case FALSE:
            case NULL:
                {
                alt52=5;
                }
                break;
            case JPA_PARAM:
            case NAMED_PARAM:
            case PARAM:
                {
                alt52=6;
                }
                break;
            case PROPERTY_REFERENCE:
                {
                alt52=7;
                }
                break;
            case SUB_QUERY:
                {
                alt52=8;
                }
                break;
            case ALIAS_REF:
                {
                alt52=9;
                }
                break;
            case DOT_CLASS:
                {
                alt52=10;
                }
                break;
            case GENERAL_FUNCTION_CALL:
                {
                alt52=11;
                }
                break;
            case JAVA_CONSTANT:
                {
                alt52=12;
                }
                break;
            case PATH:
                {
                alt52=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:261:4: caseExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_caseExpression_in_valueExpressionPrimary1299);
                    caseExpression222=caseExpression();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = caseExpression222.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:262:4: function
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_function_in_valueExpressionPrimary1304);
                    function223=function();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = function223.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:263:4: collectionFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_collectionFunction_in_valueExpressionPrimary1309);
                    collectionFunction224=collectionFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = collectionFunction224.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:264:4: collectionExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_collectionExpression_in_valueExpressionPrimary1314);
                    collectionExpression225=collectionExpression();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = collectionExpression225.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 5 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:265:4: constant
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_constant_in_valueExpressionPrimary1319);
                    constant226=constant();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = constant226.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 6 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:266:4: parameter
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parameter_in_valueExpressionPrimary1324);
                    parameter227=parameter();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = parameter227.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 7 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:267:4: propertyReference
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_propertyReference_in_valueExpressionPrimary1329);
                    propertyReference228=propertyReference();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = propertyReference228.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 8 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:268:4: ^( SUB_QUERY queryStatementSet )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    SUB_QUERY229=(CommonTree)match(input,SUB_QUERY,FOLLOW_SUB_QUERY_in_valueExpressionPrimary1335); 


                    if ( _first_0==null ) _first_0 = SUB_QUERY229;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_queryStatementSet_in_valueExpressionPrimary1337);
                    queryStatementSet230=queryStatementSet();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = queryStatementSet230.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 9 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:269:4: ALIAS_REF
                    {
                    _last = (CommonTree)input.LT(1);
                    ALIAS_REF231=(CommonTree)match(input,ALIAS_REF,FOLLOW_ALIAS_REF_in_valueExpressionPrimary1343); 
                     
                    if ( _first_0==null ) _first_0 = ALIAS_REF231;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 10 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:270:4: ^( DOT_CLASS identPrimary )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    DOT_CLASS232=(CommonTree)match(input,DOT_CLASS,FOLLOW_DOT_CLASS_in_valueExpressionPrimary1350); 


                    if ( _first_0==null ) _first_0 = DOT_CLASS232;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_identPrimary_in_valueExpressionPrimary1352);
                    identPrimary233=identPrimary();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = identPrimary233.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 11 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:271:4: ^( GENERAL_FUNCTION_CALL identPrimary )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    GENERAL_FUNCTION_CALL234=(CommonTree)match(input,GENERAL_FUNCTION_CALL,FOLLOW_GENERAL_FUNCTION_CALL_in_valueExpressionPrimary1360); 


                    if ( _first_0==null ) _first_0 = GENERAL_FUNCTION_CALL234;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_identPrimary_in_valueExpressionPrimary1362);
                    identPrimary235=identPrimary();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = identPrimary235.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 12 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:272:4: ^( JAVA_CONSTANT identPrimary )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    JAVA_CONSTANT236=(CommonTree)match(input,JAVA_CONSTANT,FOLLOW_JAVA_CONSTANT_in_valueExpressionPrimary1369); 


                    if ( _first_0==null ) _first_0 = JAVA_CONSTANT236;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_identPrimary_in_valueExpressionPrimary1371);
                    identPrimary237=identPrimary();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = identPrimary237.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 13 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:273:4: ^( PATH identPrimary )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    PATH238=(CommonTree)match(input,PATH,FOLLOW_PATH_in_valueExpressionPrimary1379); 


                    if ( _first_0==null ) _first_0 = PATH238;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_identPrimary_in_valueExpressionPrimary1381);
                    identPrimary239=identPrimary();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = identPrimary239.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "valueExpressionPrimary"

    public static class caseExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseExpression"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:276:1: caseExpression : ( ^( NULLIF valueExpression valueExpression ) | ^( COALESCE valueExpression ( valueExpression )* ) | ^( SIMPLE_CASE valueExpression ( simpleCaseWhenClause )+ ( elseClause )? ) | ^( SEARCHED_CASE ( searchedWhenClause )+ ( elseClause )? ) );
    public final TestHQLTreeWalker.caseExpression_return caseExpression() throws RecognitionException {
        TestHQLTreeWalker.caseExpression_return retval = new TestHQLTreeWalker.caseExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NULLIF240=null;
        CommonTree COALESCE243=null;
        CommonTree SIMPLE_CASE246=null;
        CommonTree SEARCHED_CASE250=null;
        TestHQLTreeWalker.valueExpression_return valueExpression241 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression242 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression244 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression245 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression247 = null;

        TestHQLTreeWalker.simpleCaseWhenClause_return simpleCaseWhenClause248 = null;

        TestHQLTreeWalker.elseClause_return elseClause249 = null;

        TestHQLTreeWalker.searchedWhenClause_return searchedWhenClause251 = null;

        TestHQLTreeWalker.elseClause_return elseClause252 = null;


        CommonTree NULLIF240_tree=null;
        CommonTree COALESCE243_tree=null;
        CommonTree SIMPLE_CASE246_tree=null;
        CommonTree SEARCHED_CASE250_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:277:2: ( ^( NULLIF valueExpression valueExpression ) | ^( COALESCE valueExpression ( valueExpression )* ) | ^( SIMPLE_CASE valueExpression ( simpleCaseWhenClause )+ ( elseClause )? ) | ^( SEARCHED_CASE ( searchedWhenClause )+ ( elseClause )? ) )
            int alt58=4;
            switch ( input.LA(1) ) {
            case NULLIF:
                {
                alt58=1;
                }
                break;
            case COALESCE:
                {
                alt58=2;
                }
                break;
            case SIMPLE_CASE:
                {
                alt58=3;
                }
                break;
            case SEARCHED_CASE:
                {
                alt58=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:277:4: ^( NULLIF valueExpression valueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    NULLIF240=(CommonTree)match(input,NULLIF,FOLLOW_NULLIF_in_caseExpression1394); 


                    if ( _first_0==null ) _first_0 = NULLIF240;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_caseExpression1396);
                    valueExpression241=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression241.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_caseExpression1398);
                    valueExpression242=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression242.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:278:4: ^( COALESCE valueExpression ( valueExpression )* )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    COALESCE243=(CommonTree)match(input,COALESCE,FOLLOW_COALESCE_in_caseExpression1405); 


                    if ( _first_0==null ) _first_0 = COALESCE243;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_caseExpression1407);
                    valueExpression244=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression244.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:278:31: ( valueExpression )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==ALIAS_REF||LA53_0==DOT_CLASS||(LA53_0>=JAVA_CONSTANT && LA53_0<=NAMED_PARAM)||LA53_0==PATH||LA53_0==PROPERTY_REFERENCE||LA53_0==SEARCHED_CASE||LA53_0==SIMPLE_CASE||(LA53_0>=SUB_QUERY && LA53_0<=VECTOR_EXPR)||(LA53_0>=ABS && LA53_0<=ALL)||LA53_0==ANY||LA53_0==AVG||LA53_0==BIT_LENGTH||(LA53_0>=CAST && LA53_0<=CHARACTER_LENGTH)||(LA53_0>=COALESCE && LA53_0<=COUNT)||(LA53_0>=CURRENT_DATE && LA53_0<=CURRENT_TIMESTAMP)||LA53_0==ELEMENTS||(LA53_0>=EXISTS && LA53_0<=EXTRACT)||(LA53_0>=INDEX && LA53_0<=INDICES)||LA53_0==LENGTH||(LA53_0>=LOCATE && LA53_0<=MAXINDEX)||(LA53_0>=MIN && LA53_0<=MININDEX)||LA53_0==MOD||(LA53_0>=NULLIF && LA53_0<=OCTET_LENGTH)||LA53_0==POSITION||(LA53_0>=SIZE && LA53_0<=SUM)||LA53_0==TRIM||LA53_0==UPPER||(LA53_0>=HEX_LITERAL && LA53_0<=OCTAL_LITERAL)||LA53_0==FLOATING_POINT_LITERAL||(LA53_0>=CHARACTER_LITERAL && LA53_0<=STRING_LITERAL)||(LA53_0>=TRUE && LA53_0<=NULL)||(LA53_0>=DOUBLE_PIPE && LA53_0<=PARAM)||(LA53_0>=PLUS && LA53_0<=SOLIDUS)||LA53_0==GENERAL_FUNCTION_CALL) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:278:31: valueExpression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_valueExpression_in_caseExpression1409);
                    	    valueExpression245=valueExpression();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = valueExpression245.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:279:4: ^( SIMPLE_CASE valueExpression ( simpleCaseWhenClause )+ ( elseClause )? )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    SIMPLE_CASE246=(CommonTree)match(input,SIMPLE_CASE,FOLLOW_SIMPLE_CASE_in_caseExpression1417); 


                    if ( _first_0==null ) _first_0 = SIMPLE_CASE246;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_valueExpression_in_caseExpression1419);
                    valueExpression247=valueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = valueExpression247.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:279:34: ( simpleCaseWhenClause )+
                    int cnt54=0;
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==WHEN) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:279:34: simpleCaseWhenClause
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_simpleCaseWhenClause_in_caseExpression1421);
                    	    simpleCaseWhenClause248=simpleCaseWhenClause();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = simpleCaseWhenClause248.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt54 >= 1 ) break loop54;
                                EarlyExitException eee =
                                    new EarlyExitException(54, input);
                                throw eee;
                        }
                        cnt54++;
                    } while (true);

                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:279:56: ( elseClause )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==ELSE) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:279:56: elseClause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_elseClause_in_caseExpression1424);
                            elseClause249=elseClause();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = elseClause249.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:280:4: ^( SEARCHED_CASE ( searchedWhenClause )+ ( elseClause )? )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    SEARCHED_CASE250=(CommonTree)match(input,SEARCHED_CASE,FOLLOW_SEARCHED_CASE_in_caseExpression1432); 


                    if ( _first_0==null ) _first_0 = SEARCHED_CASE250;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:280:20: ( searchedWhenClause )+
                    int cnt56=0;
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==WHEN) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:280:20: searchedWhenClause
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_searchedWhenClause_in_caseExpression1434);
                    	    searchedWhenClause251=searchedWhenClause();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = searchedWhenClause251.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt56 >= 1 ) break loop56;
                                EarlyExitException eee =
                                    new EarlyExitException(56, input);
                                throw eee;
                        }
                        cnt56++;
                    } while (true);

                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:280:40: ( elseClause )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==ELSE) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:280:40: elseClause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_elseClause_in_caseExpression1437);
                            elseClause252=elseClause();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = elseClause252.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseExpression"

    public static class simpleCaseWhenClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleCaseWhenClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:283:1: simpleCaseWhenClause : ^( WHEN valueExpression valueExpression ) ;
    public final TestHQLTreeWalker.simpleCaseWhenClause_return simpleCaseWhenClause() throws RecognitionException {
        TestHQLTreeWalker.simpleCaseWhenClause_return retval = new TestHQLTreeWalker.simpleCaseWhenClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHEN253=null;
        TestHQLTreeWalker.valueExpression_return valueExpression254 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression255 = null;


        CommonTree WHEN253_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:284:2: ( ^( WHEN valueExpression valueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:284:4: ^( WHEN valueExpression valueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            WHEN253=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_simpleCaseWhenClause1451); 


            if ( _first_0==null ) _first_0 = WHEN253;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_simpleCaseWhenClause1453);
            valueExpression254=valueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = valueExpression254.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_simpleCaseWhenClause1455);
            valueExpression255=valueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = valueExpression255.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simpleCaseWhenClause"

    public static class searchedWhenClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "searchedWhenClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:287:1: searchedWhenClause : ^( WHEN searchCondition valueExpression ) ;
    public final TestHQLTreeWalker.searchedWhenClause_return searchedWhenClause() throws RecognitionException {
        TestHQLTreeWalker.searchedWhenClause_return retval = new TestHQLTreeWalker.searchedWhenClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree WHEN256=null;
        TestHQLTreeWalker.searchCondition_return searchCondition257 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression258 = null;


        CommonTree WHEN256_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:288:2: ( ^( WHEN searchCondition valueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:288:4: ^( WHEN searchCondition valueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            WHEN256=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_searchedWhenClause1468); 


            if ( _first_0==null ) _first_0 = WHEN256;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_searchCondition_in_searchedWhenClause1470);
            searchCondition257=searchCondition();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = searchCondition257.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_searchedWhenClause1472);
            valueExpression258=valueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = valueExpression258.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "searchedWhenClause"

    public static class elseClause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elseClause"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:291:1: elseClause : ^( ELSE valueExpression ) ;
    public final TestHQLTreeWalker.elseClause_return elseClause() throws RecognitionException {
        TestHQLTreeWalker.elseClause_return retval = new TestHQLTreeWalker.elseClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ELSE259=null;
        TestHQLTreeWalker.valueExpression_return valueExpression260 = null;


        CommonTree ELSE259_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:292:2: ( ^( ELSE valueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:292:4: ^( ELSE valueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            ELSE259=(CommonTree)match(input,ELSE,FOLLOW_ELSE_in_elseClause1485); 


            if ( _first_0==null ) _first_0 = ELSE259;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_elseClause1487);
            valueExpression260=valueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = valueExpression260.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elseClause"

    public static class function_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:295:1: function : ( standardFunction | setFunction );
    public final TestHQLTreeWalker.function_return function() throws RecognitionException {
        TestHQLTreeWalker.function_return retval = new TestHQLTreeWalker.function_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.standardFunction_return standardFunction261 = null;

        TestHQLTreeWalker.setFunction_return setFunction262 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:296:2: ( standardFunction | setFunction )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==ABS||LA59_0==BIT_LENGTH||(LA59_0>=CAST && LA59_0<=CHARACTER_LENGTH)||LA59_0==CONCAT||(LA59_0>=CURRENT_DATE && LA59_0<=CURRENT_TIMESTAMP)||LA59_0==EXTRACT||LA59_0==INDEX||LA59_0==LENGTH||(LA59_0>=LOCATE && LA59_0<=LOWER)||LA59_0==MOD||LA59_0==OCTET_LENGTH||LA59_0==POSITION||LA59_0==SIZE||(LA59_0>=SQRT && LA59_0<=SUBSTRING)||LA59_0==TRIM||LA59_0==UPPER) ) {
                alt59=1;
            }
            else if ( (LA59_0==AVG||LA59_0==COUNT||LA59_0==MAX||LA59_0==MIN||LA59_0==SUM) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:296:4: standardFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_standardFunction_in_function1499);
                    standardFunction261=standardFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = standardFunction261.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:297:4: setFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_setFunction_in_function1504);
                    setFunction262=setFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = setFunction262.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class standardFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "standardFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:300:1: standardFunction : ( castFunction | concatFunction | substringFunction | trimFunction | upperFunction | lowerFunction | lengthFunction | locateFunction | absFunction | sqrtFunction | modFunction | sizeFunction | indexFunction | currentDateFunction | currentTimeFunction | currentTimestampFunction | extractFunction | positionFunction | charLengthFunction | octetLengthFunction | bitLengthFunction );
    public final TestHQLTreeWalker.standardFunction_return standardFunction() throws RecognitionException {
        TestHQLTreeWalker.standardFunction_return retval = new TestHQLTreeWalker.standardFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.castFunction_return castFunction263 = null;

        TestHQLTreeWalker.concatFunction_return concatFunction264 = null;

        TestHQLTreeWalker.substringFunction_return substringFunction265 = null;

        TestHQLTreeWalker.trimFunction_return trimFunction266 = null;

        TestHQLTreeWalker.upperFunction_return upperFunction267 = null;

        TestHQLTreeWalker.lowerFunction_return lowerFunction268 = null;

        TestHQLTreeWalker.lengthFunction_return lengthFunction269 = null;

        TestHQLTreeWalker.locateFunction_return locateFunction270 = null;

        TestHQLTreeWalker.absFunction_return absFunction271 = null;

        TestHQLTreeWalker.sqrtFunction_return sqrtFunction272 = null;

        TestHQLTreeWalker.modFunction_return modFunction273 = null;

        TestHQLTreeWalker.sizeFunction_return sizeFunction274 = null;

        TestHQLTreeWalker.indexFunction_return indexFunction275 = null;

        TestHQLTreeWalker.currentDateFunction_return currentDateFunction276 = null;

        TestHQLTreeWalker.currentTimeFunction_return currentTimeFunction277 = null;

        TestHQLTreeWalker.currentTimestampFunction_return currentTimestampFunction278 = null;

        TestHQLTreeWalker.extractFunction_return extractFunction279 = null;

        TestHQLTreeWalker.positionFunction_return positionFunction280 = null;

        TestHQLTreeWalker.charLengthFunction_return charLengthFunction281 = null;

        TestHQLTreeWalker.octetLengthFunction_return octetLengthFunction282 = null;

        TestHQLTreeWalker.bitLengthFunction_return bitLengthFunction283 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:301:2: ( castFunction | concatFunction | substringFunction | trimFunction | upperFunction | lowerFunction | lengthFunction | locateFunction | absFunction | sqrtFunction | modFunction | sizeFunction | indexFunction | currentDateFunction | currentTimeFunction | currentTimestampFunction | extractFunction | positionFunction | charLengthFunction | octetLengthFunction | bitLengthFunction )
            int alt60=21;
            switch ( input.LA(1) ) {
            case CAST:
                {
                alt60=1;
                }
                break;
            case CONCAT:
                {
                alt60=2;
                }
                break;
            case SUBSTRING:
                {
                alt60=3;
                }
                break;
            case TRIM:
                {
                alt60=4;
                }
                break;
            case UPPER:
                {
                alt60=5;
                }
                break;
            case LOWER:
                {
                alt60=6;
                }
                break;
            case LENGTH:
                {
                alt60=7;
                }
                break;
            case LOCATE:
                {
                alt60=8;
                }
                break;
            case ABS:
                {
                alt60=9;
                }
                break;
            case SQRT:
                {
                alt60=10;
                }
                break;
            case MOD:
                {
                alt60=11;
                }
                break;
            case SIZE:
                {
                alt60=12;
                }
                break;
            case INDEX:
                {
                alt60=13;
                }
                break;
            case CURRENT_DATE:
                {
                alt60=14;
                }
                break;
            case CURRENT_TIME:
                {
                alt60=15;
                }
                break;
            case CURRENT_TIMESTAMP:
                {
                alt60=16;
                }
                break;
            case EXTRACT:
                {
                alt60=17;
                }
                break;
            case POSITION:
                {
                alt60=18;
                }
                break;
            case CHARACTER_LENGTH:
                {
                alt60=19;
                }
                break;
            case OCTET_LENGTH:
                {
                alt60=20;
                }
                break;
            case BIT_LENGTH:
                {
                alt60=21;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:301:4: castFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_castFunction_in_standardFunction1515);
                    castFunction263=castFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = castFunction263.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:302:4: concatFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_concatFunction_in_standardFunction1520);
                    concatFunction264=concatFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = concatFunction264.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:303:4: substringFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_substringFunction_in_standardFunction1525);
                    substringFunction265=substringFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = substringFunction265.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:304:4: trimFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_trimFunction_in_standardFunction1530);
                    trimFunction266=trimFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = trimFunction266.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 5 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:305:4: upperFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_upperFunction_in_standardFunction1535);
                    upperFunction267=upperFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = upperFunction267.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 6 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:306:4: lowerFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_lowerFunction_in_standardFunction1540);
                    lowerFunction268=lowerFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = lowerFunction268.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 7 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:307:4: lengthFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_lengthFunction_in_standardFunction1545);
                    lengthFunction269=lengthFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = lengthFunction269.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 8 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:308:4: locateFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_locateFunction_in_standardFunction1550);
                    locateFunction270=locateFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = locateFunction270.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 9 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:309:4: absFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_absFunction_in_standardFunction1555);
                    absFunction271=absFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = absFunction271.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 10 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:310:4: sqrtFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sqrtFunction_in_standardFunction1560);
                    sqrtFunction272=sqrtFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = sqrtFunction272.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 11 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:311:4: modFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_modFunction_in_standardFunction1565);
                    modFunction273=modFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = modFunction273.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 12 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:312:4: sizeFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sizeFunction_in_standardFunction1570);
                    sizeFunction274=sizeFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = sizeFunction274.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 13 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:313:4: indexFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_indexFunction_in_standardFunction1575);
                    indexFunction275=indexFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = indexFunction275.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 14 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:314:4: currentDateFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_currentDateFunction_in_standardFunction1580);
                    currentDateFunction276=currentDateFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = currentDateFunction276.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 15 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:315:4: currentTimeFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_currentTimeFunction_in_standardFunction1585);
                    currentTimeFunction277=currentTimeFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = currentTimeFunction277.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 16 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:316:4: currentTimestampFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_currentTimestampFunction_in_standardFunction1590);
                    currentTimestampFunction278=currentTimestampFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = currentTimestampFunction278.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 17 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:317:4: extractFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_extractFunction_in_standardFunction1595);
                    extractFunction279=extractFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = extractFunction279.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 18 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:318:4: positionFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_positionFunction_in_standardFunction1600);
                    positionFunction280=positionFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = positionFunction280.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 19 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:319:4: charLengthFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_charLengthFunction_in_standardFunction1605);
                    charLengthFunction281=charLengthFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = charLengthFunction281.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 20 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:320:4: octetLengthFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_octetLengthFunction_in_standardFunction1610);
                    octetLengthFunction282=octetLengthFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = octetLengthFunction282.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 21 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:321:4: bitLengthFunction
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bitLengthFunction_in_standardFunction1615);
                    bitLengthFunction283=bitLengthFunction();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = bitLengthFunction283.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "standardFunction"

    public static class castFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "castFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:324:1: castFunction : ^( CAST valueExpression IDENTIFIER ) ;
    public final TestHQLTreeWalker.castFunction_return castFunction() throws RecognitionException {
        TestHQLTreeWalker.castFunction_return retval = new TestHQLTreeWalker.castFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CAST284=null;
        CommonTree IDENTIFIER286=null;
        TestHQLTreeWalker.valueExpression_return valueExpression285 = null;


        CommonTree CAST284_tree=null;
        CommonTree IDENTIFIER286_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:325:2: ( ^( CAST valueExpression IDENTIFIER ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:325:4: ^( CAST valueExpression IDENTIFIER )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            CAST284=(CommonTree)match(input,CAST,FOLLOW_CAST_in_castFunction1627); 


            if ( _first_0==null ) _first_0 = CAST284;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_valueExpression_in_castFunction1629);
            valueExpression285=valueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = valueExpression285.tree;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER286=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_castFunction1631); 
             
            if ( _first_1==null ) _first_1 = IDENTIFIER286;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "castFunction"

    public static class concatFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:328:1: concatFunction : ^( CONCAT ( valueExpression )+ ) ;
    public final TestHQLTreeWalker.concatFunction_return concatFunction() throws RecognitionException {
        TestHQLTreeWalker.concatFunction_return retval = new TestHQLTreeWalker.concatFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CONCAT287=null;
        TestHQLTreeWalker.valueExpression_return valueExpression288 = null;


        CommonTree CONCAT287_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:329:2: ( ^( CONCAT ( valueExpression )+ ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:329:4: ^( CONCAT ( valueExpression )+ )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            CONCAT287=(CommonTree)match(input,CONCAT,FOLLOW_CONCAT_in_concatFunction1644); 


            if ( _first_0==null ) _first_0 = CONCAT287;
            match(input, Token.DOWN, null); 
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:329:13: ( valueExpression )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==ALIAS_REF||LA61_0==DOT_CLASS||(LA61_0>=JAVA_CONSTANT && LA61_0<=NAMED_PARAM)||LA61_0==PATH||LA61_0==PROPERTY_REFERENCE||LA61_0==SEARCHED_CASE||LA61_0==SIMPLE_CASE||(LA61_0>=SUB_QUERY && LA61_0<=VECTOR_EXPR)||(LA61_0>=ABS && LA61_0<=ALL)||LA61_0==ANY||LA61_0==AVG||LA61_0==BIT_LENGTH||(LA61_0>=CAST && LA61_0<=CHARACTER_LENGTH)||(LA61_0>=COALESCE && LA61_0<=COUNT)||(LA61_0>=CURRENT_DATE && LA61_0<=CURRENT_TIMESTAMP)||LA61_0==ELEMENTS||(LA61_0>=EXISTS && LA61_0<=EXTRACT)||(LA61_0>=INDEX && LA61_0<=INDICES)||LA61_0==LENGTH||(LA61_0>=LOCATE && LA61_0<=MAXINDEX)||(LA61_0>=MIN && LA61_0<=MININDEX)||LA61_0==MOD||(LA61_0>=NULLIF && LA61_0<=OCTET_LENGTH)||LA61_0==POSITION||(LA61_0>=SIZE && LA61_0<=SUM)||LA61_0==TRIM||LA61_0==UPPER||(LA61_0>=HEX_LITERAL && LA61_0<=OCTAL_LITERAL)||LA61_0==FLOATING_POINT_LITERAL||(LA61_0>=CHARACTER_LITERAL && LA61_0<=STRING_LITERAL)||(LA61_0>=TRUE && LA61_0<=NULL)||(LA61_0>=DOUBLE_PIPE && LA61_0<=PARAM)||(LA61_0>=PLUS && LA61_0<=SOLIDUS)||LA61_0==GENERAL_FUNCTION_CALL) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:329:13: valueExpression
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_valueExpression_in_concatFunction1646);
            	    valueExpression288=valueExpression();

            	    state._fsp--;

            	     
            	    if ( _first_1==null ) _first_1 = valueExpression288.tree;

            	    retval.tree = (CommonTree)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "concatFunction"

    public static class substringFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "substringFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:332:1: substringFunction : ^( SUBSTRING characterValueExpression numericValueExpression ( numericValueExpression )? ) ;
    public final TestHQLTreeWalker.substringFunction_return substringFunction() throws RecognitionException {
        TestHQLTreeWalker.substringFunction_return retval = new TestHQLTreeWalker.substringFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SUBSTRING289=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression290 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression291 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression292 = null;


        CommonTree SUBSTRING289_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:333:2: ( ^( SUBSTRING characterValueExpression numericValueExpression ( numericValueExpression )? ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:333:4: ^( SUBSTRING characterValueExpression numericValueExpression ( numericValueExpression )? )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            SUBSTRING289=(CommonTree)match(input,SUBSTRING,FOLLOW_SUBSTRING_in_substringFunction1660); 


            if ( _first_0==null ) _first_0 = SUBSTRING289;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_substringFunction1662);
            characterValueExpression290=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression290.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_numericValueExpression_in_substringFunction1664);
            numericValueExpression291=numericValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = numericValueExpression291.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:333:64: ( numericValueExpression )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==ALIAS_REF||LA62_0==DOT_CLASS||(LA62_0>=JAVA_CONSTANT && LA62_0<=NAMED_PARAM)||LA62_0==PATH||LA62_0==PROPERTY_REFERENCE||LA62_0==SEARCHED_CASE||LA62_0==SIMPLE_CASE||(LA62_0>=SUB_QUERY && LA62_0<=VECTOR_EXPR)||(LA62_0>=ABS && LA62_0<=ALL)||LA62_0==ANY||LA62_0==AVG||LA62_0==BIT_LENGTH||(LA62_0>=CAST && LA62_0<=CHARACTER_LENGTH)||(LA62_0>=COALESCE && LA62_0<=COUNT)||(LA62_0>=CURRENT_DATE && LA62_0<=CURRENT_TIMESTAMP)||LA62_0==ELEMENTS||(LA62_0>=EXISTS && LA62_0<=EXTRACT)||(LA62_0>=INDEX && LA62_0<=INDICES)||LA62_0==LENGTH||(LA62_0>=LOCATE && LA62_0<=MAXINDEX)||(LA62_0>=MIN && LA62_0<=MININDEX)||LA62_0==MOD||(LA62_0>=NULLIF && LA62_0<=OCTET_LENGTH)||LA62_0==POSITION||(LA62_0>=SIZE && LA62_0<=SUM)||LA62_0==TRIM||LA62_0==UPPER||(LA62_0>=HEX_LITERAL && LA62_0<=OCTAL_LITERAL)||LA62_0==FLOATING_POINT_LITERAL||(LA62_0>=CHARACTER_LITERAL && LA62_0<=STRING_LITERAL)||(LA62_0>=TRUE && LA62_0<=NULL)||(LA62_0>=DOUBLE_PIPE && LA62_0<=PARAM)||(LA62_0>=PLUS && LA62_0<=SOLIDUS)||LA62_0==GENERAL_FUNCTION_CALL) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:333:64: numericValueExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_substringFunction1666);
                    numericValueExpression292=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression292.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "substringFunction"

    public static class trimFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trimFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:336:1: trimFunction : ^( TRIM trimOperands ) ;
    public final TestHQLTreeWalker.trimFunction_return trimFunction() throws RecognitionException {
        TestHQLTreeWalker.trimFunction_return retval = new TestHQLTreeWalker.trimFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TRIM293=null;
        TestHQLTreeWalker.trimOperands_return trimOperands294 = null;


        CommonTree TRIM293_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:337:2: ( ^( TRIM trimOperands ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:337:4: ^( TRIM trimOperands )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            TRIM293=(CommonTree)match(input,TRIM,FOLLOW_TRIM_in_trimFunction1680); 


            if ( _first_0==null ) _first_0 = TRIM293;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_trimOperands_in_trimFunction1682);
            trimOperands294=trimOperands();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = trimOperands294.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "trimFunction"

    public static class trimOperands_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trimOperands"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:340:1: trimOperands : ^( ( LEADING | TRAILING | BOTH ) characterValueExpression characterValueExpression ) ;
    public final TestHQLTreeWalker.trimOperands_return trimOperands() throws RecognitionException {
        TestHQLTreeWalker.trimOperands_return retval = new TestHQLTreeWalker.trimOperands_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set295=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression296 = null;

        TestHQLTreeWalker.characterValueExpression_return characterValueExpression297 = null;


        CommonTree set295_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:341:2: ( ^( ( LEADING | TRAILING | BOTH ) characterValueExpression characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:341:4: ^( ( LEADING | TRAILING | BOTH ) characterValueExpression characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            set295=(CommonTree)input.LT(1);
            if ( input.LA(1)==BOTH||input.LA(1)==LEADING||input.LA(1)==TRAILING ) {
                input.consume();


                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            if ( _first_0==null ) _first_0 = set295;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_trimOperands1703);
            characterValueExpression296=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression296.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_trimOperands1705);
            characterValueExpression297=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression297.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "trimOperands"

    public static class upperFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "upperFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:344:1: upperFunction : ^( UPPER characterValueExpression ) ;
    public final TestHQLTreeWalker.upperFunction_return upperFunction() throws RecognitionException {
        TestHQLTreeWalker.upperFunction_return retval = new TestHQLTreeWalker.upperFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UPPER298=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression299 = null;


        CommonTree UPPER298_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:345:2: ( ^( UPPER characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:345:4: ^( UPPER characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            UPPER298=(CommonTree)match(input,UPPER,FOLLOW_UPPER_in_upperFunction1718); 


            if ( _first_0==null ) _first_0 = UPPER298;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_upperFunction1720);
            characterValueExpression299=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression299.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "upperFunction"

    public static class lowerFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lowerFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:348:1: lowerFunction : ^( LOWER characterValueExpression ) ;
    public final TestHQLTreeWalker.lowerFunction_return lowerFunction() throws RecognitionException {
        TestHQLTreeWalker.lowerFunction_return retval = new TestHQLTreeWalker.lowerFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOWER300=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression301 = null;


        CommonTree LOWER300_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:349:2: ( ^( LOWER characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:349:4: ^( LOWER characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            LOWER300=(CommonTree)match(input,LOWER,FOLLOW_LOWER_in_lowerFunction1733); 


            if ( _first_0==null ) _first_0 = LOWER300;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_lowerFunction1735);
            characterValueExpression301=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression301.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "lowerFunction"

    public static class lengthFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lengthFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:352:1: lengthFunction : ^( LENGTH characterValueExpression ) ;
    public final TestHQLTreeWalker.lengthFunction_return lengthFunction() throws RecognitionException {
        TestHQLTreeWalker.lengthFunction_return retval = new TestHQLTreeWalker.lengthFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LENGTH302=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression303 = null;


        CommonTree LENGTH302_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:353:2: ( ^( LENGTH characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:353:4: ^( LENGTH characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            LENGTH302=(CommonTree)match(input,LENGTH,FOLLOW_LENGTH_in_lengthFunction1748); 


            if ( _first_0==null ) _first_0 = LENGTH302;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_lengthFunction1750);
            characterValueExpression303=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression303.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "lengthFunction"

    public static class locateFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "locateFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:356:1: locateFunction : ^( LOCATE characterValueExpression characterValueExpression ( numericValueExpression )? ) ;
    public final TestHQLTreeWalker.locateFunction_return locateFunction() throws RecognitionException {
        TestHQLTreeWalker.locateFunction_return retval = new TestHQLTreeWalker.locateFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOCATE304=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression305 = null;

        TestHQLTreeWalker.characterValueExpression_return characterValueExpression306 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression307 = null;


        CommonTree LOCATE304_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:357:2: ( ^( LOCATE characterValueExpression characterValueExpression ( numericValueExpression )? ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:357:4: ^( LOCATE characterValueExpression characterValueExpression ( numericValueExpression )? )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            LOCATE304=(CommonTree)match(input,LOCATE,FOLLOW_LOCATE_in_locateFunction1763); 


            if ( _first_0==null ) _first_0 = LOCATE304;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_locateFunction1765);
            characterValueExpression305=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression305.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_locateFunction1767);
            characterValueExpression306=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression306.tree;
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:357:63: ( numericValueExpression )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==ALIAS_REF||LA63_0==DOT_CLASS||(LA63_0>=JAVA_CONSTANT && LA63_0<=NAMED_PARAM)||LA63_0==PATH||LA63_0==PROPERTY_REFERENCE||LA63_0==SEARCHED_CASE||LA63_0==SIMPLE_CASE||(LA63_0>=SUB_QUERY && LA63_0<=VECTOR_EXPR)||(LA63_0>=ABS && LA63_0<=ALL)||LA63_0==ANY||LA63_0==AVG||LA63_0==BIT_LENGTH||(LA63_0>=CAST && LA63_0<=CHARACTER_LENGTH)||(LA63_0>=COALESCE && LA63_0<=COUNT)||(LA63_0>=CURRENT_DATE && LA63_0<=CURRENT_TIMESTAMP)||LA63_0==ELEMENTS||(LA63_0>=EXISTS && LA63_0<=EXTRACT)||(LA63_0>=INDEX && LA63_0<=INDICES)||LA63_0==LENGTH||(LA63_0>=LOCATE && LA63_0<=MAXINDEX)||(LA63_0>=MIN && LA63_0<=MININDEX)||LA63_0==MOD||(LA63_0>=NULLIF && LA63_0<=OCTET_LENGTH)||LA63_0==POSITION||(LA63_0>=SIZE && LA63_0<=SUM)||LA63_0==TRIM||LA63_0==UPPER||(LA63_0>=HEX_LITERAL && LA63_0<=OCTAL_LITERAL)||LA63_0==FLOATING_POINT_LITERAL||(LA63_0>=CHARACTER_LITERAL && LA63_0<=STRING_LITERAL)||(LA63_0>=TRUE && LA63_0<=NULL)||(LA63_0>=DOUBLE_PIPE && LA63_0<=PARAM)||(LA63_0>=PLUS && LA63_0<=SOLIDUS)||LA63_0==GENERAL_FUNCTION_CALL) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:357:63: numericValueExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_locateFunction1769);
                    numericValueExpression307=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression307.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }


            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "locateFunction"

    public static class absFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "absFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:360:1: absFunction : ^( ABS numericValueExpression ) ;
    public final TestHQLTreeWalker.absFunction_return absFunction() throws RecognitionException {
        TestHQLTreeWalker.absFunction_return retval = new TestHQLTreeWalker.absFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ABS308=null;
        TestHQLTreeWalker.numericValueExpression_return numericValueExpression309 = null;


        CommonTree ABS308_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:361:2: ( ^( ABS numericValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:361:4: ^( ABS numericValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            ABS308=(CommonTree)match(input,ABS,FOLLOW_ABS_in_absFunction1783); 


            if ( _first_0==null ) _first_0 = ABS308;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_numericValueExpression_in_absFunction1785);
            numericValueExpression309=numericValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = numericValueExpression309.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "absFunction"

    public static class sqrtFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sqrtFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:364:1: sqrtFunction : ^( SQRT numericValueExpression ) ;
    public final TestHQLTreeWalker.sqrtFunction_return sqrtFunction() throws RecognitionException {
        TestHQLTreeWalker.sqrtFunction_return retval = new TestHQLTreeWalker.sqrtFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SQRT310=null;
        TestHQLTreeWalker.numericValueExpression_return numericValueExpression311 = null;


        CommonTree SQRT310_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:365:2: ( ^( SQRT numericValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:365:4: ^( SQRT numericValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            SQRT310=(CommonTree)match(input,SQRT,FOLLOW_SQRT_in_sqrtFunction1798); 


            if ( _first_0==null ) _first_0 = SQRT310;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_numericValueExpression_in_sqrtFunction1800);
            numericValueExpression311=numericValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = numericValueExpression311.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sqrtFunction"

    public static class modFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:368:1: modFunction : ^( MOD numericValueExpression numericValueExpression ) ;
    public final TestHQLTreeWalker.modFunction_return modFunction() throws RecognitionException {
        TestHQLTreeWalker.modFunction_return retval = new TestHQLTreeWalker.modFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MOD312=null;
        TestHQLTreeWalker.numericValueExpression_return numericValueExpression313 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression314 = null;


        CommonTree MOD312_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:369:2: ( ^( MOD numericValueExpression numericValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:369:4: ^( MOD numericValueExpression numericValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            MOD312=(CommonTree)match(input,MOD,FOLLOW_MOD_in_modFunction1813); 


            if ( _first_0==null ) _first_0 = MOD312;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_numericValueExpression_in_modFunction1815);
            numericValueExpression313=numericValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = numericValueExpression313.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_numericValueExpression_in_modFunction1817);
            numericValueExpression314=numericValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = numericValueExpression314.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "modFunction"

    public static class sizeFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sizeFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:372:1: sizeFunction : ^( SIZE propertyReference ) ;
    public final TestHQLTreeWalker.sizeFunction_return sizeFunction() throws RecognitionException {
        TestHQLTreeWalker.sizeFunction_return retval = new TestHQLTreeWalker.sizeFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SIZE315=null;
        TestHQLTreeWalker.propertyReference_return propertyReference316 = null;


        CommonTree SIZE315_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:373:2: ( ^( SIZE propertyReference ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:373:4: ^( SIZE propertyReference )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            SIZE315=(CommonTree)match(input,SIZE,FOLLOW_SIZE_in_sizeFunction1830); 


            if ( _first_0==null ) _first_0 = SIZE315;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_propertyReference_in_sizeFunction1832);
            propertyReference316=propertyReference();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = propertyReference316.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sizeFunction"

    public static class indexFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indexFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:376:1: indexFunction : ^( INDEX ALIAS_REF ) ;
    public final TestHQLTreeWalker.indexFunction_return indexFunction() throws RecognitionException {
        TestHQLTreeWalker.indexFunction_return retval = new TestHQLTreeWalker.indexFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INDEX317=null;
        CommonTree ALIAS_REF318=null;

        CommonTree INDEX317_tree=null;
        CommonTree ALIAS_REF318_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:377:2: ( ^( INDEX ALIAS_REF ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:377:4: ^( INDEX ALIAS_REF )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            INDEX317=(CommonTree)match(input,INDEX,FOLLOW_INDEX_in_indexFunction1845); 


            if ( _first_0==null ) _first_0 = INDEX317;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            ALIAS_REF318=(CommonTree)match(input,ALIAS_REF,FOLLOW_ALIAS_REF_in_indexFunction1847); 
             
            if ( _first_1==null ) _first_1 = ALIAS_REF318;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "indexFunction"

    public static class currentDateFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "currentDateFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:380:1: currentDateFunction : CURRENT_DATE ;
    public final TestHQLTreeWalker.currentDateFunction_return currentDateFunction() throws RecognitionException {
        TestHQLTreeWalker.currentDateFunction_return retval = new TestHQLTreeWalker.currentDateFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CURRENT_DATE319=null;

        CommonTree CURRENT_DATE319_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:381:2: ( CURRENT_DATE )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:381:4: CURRENT_DATE
            {
            _last = (CommonTree)input.LT(1);
            CURRENT_DATE319=(CommonTree)match(input,CURRENT_DATE,FOLLOW_CURRENT_DATE_in_currentDateFunction1859); 
             
            if ( _first_0==null ) _first_0 = CURRENT_DATE319;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "currentDateFunction"

    public static class currentTimeFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "currentTimeFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:384:1: currentTimeFunction : CURRENT_TIME ;
    public final TestHQLTreeWalker.currentTimeFunction_return currentTimeFunction() throws RecognitionException {
        TestHQLTreeWalker.currentTimeFunction_return retval = new TestHQLTreeWalker.currentTimeFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CURRENT_TIME320=null;

        CommonTree CURRENT_TIME320_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:385:2: ( CURRENT_TIME )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:385:4: CURRENT_TIME
            {
            _last = (CommonTree)input.LT(1);
            CURRENT_TIME320=(CommonTree)match(input,CURRENT_TIME,FOLLOW_CURRENT_TIME_in_currentTimeFunction1870); 
             
            if ( _first_0==null ) _first_0 = CURRENT_TIME320;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "currentTimeFunction"

    public static class currentTimestampFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "currentTimestampFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:388:1: currentTimestampFunction : CURRENT_TIMESTAMP ;
    public final TestHQLTreeWalker.currentTimestampFunction_return currentTimestampFunction() throws RecognitionException {
        TestHQLTreeWalker.currentTimestampFunction_return retval = new TestHQLTreeWalker.currentTimestampFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CURRENT_TIMESTAMP321=null;

        CommonTree CURRENT_TIMESTAMP321_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:389:2: ( CURRENT_TIMESTAMP )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:389:4: CURRENT_TIMESTAMP
            {
            _last = (CommonTree)input.LT(1);
            CURRENT_TIMESTAMP321=(CommonTree)match(input,CURRENT_TIMESTAMP,FOLLOW_CURRENT_TIMESTAMP_in_currentTimestampFunction1881); 
             
            if ( _first_0==null ) _first_0 = CURRENT_TIMESTAMP321;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "currentTimestampFunction"

    public static class extractFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extractFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:392:1: extractFunction : ^( EXTRACT extractField datetimeValueExpression ) ;
    public final TestHQLTreeWalker.extractFunction_return extractFunction() throws RecognitionException {
        TestHQLTreeWalker.extractFunction_return retval = new TestHQLTreeWalker.extractFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXTRACT322=null;
        TestHQLTreeWalker.extractField_return extractField323 = null;

        TestHQLTreeWalker.datetimeValueExpression_return datetimeValueExpression324 = null;


        CommonTree EXTRACT322_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:393:2: ( ^( EXTRACT extractField datetimeValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:393:4: ^( EXTRACT extractField datetimeValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            EXTRACT322=(CommonTree)match(input,EXTRACT,FOLLOW_EXTRACT_in_extractFunction1893); 


            if ( _first_0==null ) _first_0 = EXTRACT322;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_extractField_in_extractFunction1895);
            extractField323=extractField();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = extractField323.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_datetimeValueExpression_in_extractFunction1897);
            datetimeValueExpression324=datetimeValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = datetimeValueExpression324.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "extractFunction"

    public static class extractField_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extractField"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:396:1: extractField : ( datetimeField | timeZoneField );
    public final TestHQLTreeWalker.extractField_return extractField() throws RecognitionException {
        TestHQLTreeWalker.extractField_return retval = new TestHQLTreeWalker.extractField_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.datetimeField_return datetimeField325 = null;

        TestHQLTreeWalker.timeZoneField_return timeZoneField326 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:397:2: ( datetimeField | timeZoneField )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==DAY||LA64_0==HOUR||LA64_0==MINUTE||LA64_0==MONTH||LA64_0==SECOND||LA64_0==YEAR) ) {
                alt64=1;
            }
            else if ( ((LA64_0>=TIMEZONE_HOUR && LA64_0<=TIMEZONE_MINUTE)) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:397:4: datetimeField
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_datetimeField_in_extractField1909);
                    datetimeField325=datetimeField();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = datetimeField325.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:398:4: timeZoneField
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_timeZoneField_in_extractField1914);
                    timeZoneField326=timeZoneField();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = timeZoneField326.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "extractField"

    public static class datetimeField_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "datetimeField"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:401:1: datetimeField : ( YEAR | MONTH | DAY | HOUR | MINUTE | SECOND );
    public final TestHQLTreeWalker.datetimeField_return datetimeField() throws RecognitionException {
        TestHQLTreeWalker.datetimeField_return retval = new TestHQLTreeWalker.datetimeField_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set327=null;

        CommonTree set327_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:402:2: ( YEAR | MONTH | DAY | HOUR | MINUTE | SECOND )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:
            {
            _last = (CommonTree)input.LT(1);
            set327=(CommonTree)input.LT(1);
            if ( input.LA(1)==DAY||input.LA(1)==HOUR||input.LA(1)==MINUTE||input.LA(1)==MONTH||input.LA(1)==SECOND||input.LA(1)==YEAR ) {
                input.consume();


                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "datetimeField"

    public static class timeZoneField_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "timeZoneField"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:410:1: timeZoneField : ( TIMEZONE_HOUR | TIMEZONE_MINUTE );
    public final TestHQLTreeWalker.timeZoneField_return timeZoneField() throws RecognitionException {
        TestHQLTreeWalker.timeZoneField_return retval = new TestHQLTreeWalker.timeZoneField_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set328=null;

        CommonTree set328_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:411:2: ( TIMEZONE_HOUR | TIMEZONE_MINUTE )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:
            {
            _last = (CommonTree)input.LT(1);
            set328=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=TIMEZONE_HOUR && input.LA(1)<=TIMEZONE_MINUTE) ) {
                input.consume();


                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "timeZoneField"

    public static class positionFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "positionFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:415:1: positionFunction : ^( POSITION characterValueExpression characterValueExpression ) ;
    public final TestHQLTreeWalker.positionFunction_return positionFunction() throws RecognitionException {
        TestHQLTreeWalker.positionFunction_return retval = new TestHQLTreeWalker.positionFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POSITION329=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression330 = null;

        TestHQLTreeWalker.characterValueExpression_return characterValueExpression331 = null;


        CommonTree POSITION329_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:416:2: ( ^( POSITION characterValueExpression characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:416:4: ^( POSITION characterValueExpression characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            POSITION329=(CommonTree)match(input,POSITION,FOLLOW_POSITION_in_positionFunction1978); 


            if ( _first_0==null ) _first_0 = POSITION329;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_positionFunction1980);
            characterValueExpression330=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression330.tree;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_positionFunction1982);
            characterValueExpression331=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression331.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "positionFunction"

    public static class charLengthFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "charLengthFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:419:1: charLengthFunction : ^( CHARACTER_LENGTH characterValueExpression ) ;
    public final TestHQLTreeWalker.charLengthFunction_return charLengthFunction() throws RecognitionException {
        TestHQLTreeWalker.charLengthFunction_return retval = new TestHQLTreeWalker.charLengthFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CHARACTER_LENGTH332=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression333 = null;


        CommonTree CHARACTER_LENGTH332_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:420:2: ( ^( CHARACTER_LENGTH characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:420:4: ^( CHARACTER_LENGTH characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            CHARACTER_LENGTH332=(CommonTree)match(input,CHARACTER_LENGTH,FOLLOW_CHARACTER_LENGTH_in_charLengthFunction1995); 


            if ( _first_0==null ) _first_0 = CHARACTER_LENGTH332;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_charLengthFunction1997);
            characterValueExpression333=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression333.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "charLengthFunction"

    public static class octetLengthFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "octetLengthFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:423:1: octetLengthFunction : ^( OCTET_LENGTH characterValueExpression ) ;
    public final TestHQLTreeWalker.octetLengthFunction_return octetLengthFunction() throws RecognitionException {
        TestHQLTreeWalker.octetLengthFunction_return retval = new TestHQLTreeWalker.octetLengthFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OCTET_LENGTH334=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression335 = null;


        CommonTree OCTET_LENGTH334_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:424:2: ( ^( OCTET_LENGTH characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:424:4: ^( OCTET_LENGTH characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            OCTET_LENGTH334=(CommonTree)match(input,OCTET_LENGTH,FOLLOW_OCTET_LENGTH_in_octetLengthFunction2010); 


            if ( _first_0==null ) _first_0 = OCTET_LENGTH334;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_octetLengthFunction2012);
            characterValueExpression335=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression335.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "octetLengthFunction"

    public static class bitLengthFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitLengthFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:427:1: bitLengthFunction : ^( BIT_LENGTH characterValueExpression ) ;
    public final TestHQLTreeWalker.bitLengthFunction_return bitLengthFunction() throws RecognitionException {
        TestHQLTreeWalker.bitLengthFunction_return retval = new TestHQLTreeWalker.bitLengthFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIT_LENGTH336=null;
        TestHQLTreeWalker.characterValueExpression_return characterValueExpression337 = null;


        CommonTree BIT_LENGTH336_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:428:2: ( ^( BIT_LENGTH characterValueExpression ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:428:4: ^( BIT_LENGTH characterValueExpression )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            BIT_LENGTH336=(CommonTree)match(input,BIT_LENGTH,FOLLOW_BIT_LENGTH_in_bitLengthFunction2026); 


            if ( _first_0==null ) _first_0 = BIT_LENGTH336;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_characterValueExpression_in_bitLengthFunction2028);
            characterValueExpression337=characterValueExpression();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = characterValueExpression337.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitLengthFunction"

    public static class setFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "setFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:431:1: setFunction : ( ^( SUM numericValueExpression ) | ^( AVG numericValueExpression ) | ^( MAX numericValueExpression ) | ^( MIN numericValueExpression ) | ^( COUNT ( ASTERISK | ( DISTINCT | ALL ) countFunctionArguments ) ) );
    public final TestHQLTreeWalker.setFunction_return setFunction() throws RecognitionException {
        TestHQLTreeWalker.setFunction_return retval = new TestHQLTreeWalker.setFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SUM338=null;
        CommonTree AVG340=null;
        CommonTree MAX342=null;
        CommonTree MIN344=null;
        CommonTree COUNT346=null;
        CommonTree ASTERISK347=null;
        CommonTree set348=null;
        TestHQLTreeWalker.numericValueExpression_return numericValueExpression339 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression341 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression343 = null;

        TestHQLTreeWalker.numericValueExpression_return numericValueExpression345 = null;

        TestHQLTreeWalker.countFunctionArguments_return countFunctionArguments349 = null;


        CommonTree SUM338_tree=null;
        CommonTree AVG340_tree=null;
        CommonTree MAX342_tree=null;
        CommonTree MIN344_tree=null;
        CommonTree COUNT346_tree=null;
        CommonTree ASTERISK347_tree=null;
        CommonTree set348_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:432:2: ( ^( SUM numericValueExpression ) | ^( AVG numericValueExpression ) | ^( MAX numericValueExpression ) | ^( MIN numericValueExpression ) | ^( COUNT ( ASTERISK | ( DISTINCT | ALL ) countFunctionArguments ) ) )
            int alt66=5;
            switch ( input.LA(1) ) {
            case SUM:
                {
                alt66=1;
                }
                break;
            case AVG:
                {
                alt66=2;
                }
                break;
            case MAX:
                {
                alt66=3;
                }
                break;
            case MIN:
                {
                alt66=4;
                }
                break;
            case COUNT:
                {
                alt66=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:432:4: ^( SUM numericValueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    SUM338=(CommonTree)match(input,SUM,FOLLOW_SUM_in_setFunction2041); 


                    if ( _first_0==null ) _first_0 = SUM338;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_setFunction2043);
                    numericValueExpression339=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression339.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:433:4: ^( AVG numericValueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    AVG340=(CommonTree)match(input,AVG,FOLLOW_AVG_in_setFunction2050); 


                    if ( _first_0==null ) _first_0 = AVG340;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_setFunction2052);
                    numericValueExpression341=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression341.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:434:4: ^( MAX numericValueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    MAX342=(CommonTree)match(input,MAX,FOLLOW_MAX_in_setFunction2059); 


                    if ( _first_0==null ) _first_0 = MAX342;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_setFunction2061);
                    numericValueExpression343=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression343.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:435:4: ^( MIN numericValueExpression )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    MIN344=(CommonTree)match(input,MIN,FOLLOW_MIN_in_setFunction2068); 


                    if ( _first_0==null ) _first_0 = MIN344;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numericValueExpression_in_setFunction2070);
                    numericValueExpression345=numericValueExpression();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = numericValueExpression345.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 5 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:436:4: ^( COUNT ( ASTERISK | ( DISTINCT | ALL ) countFunctionArguments ) )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    COUNT346=(CommonTree)match(input,COUNT,FOLLOW_COUNT_in_setFunction2077); 


                    if ( _first_0==null ) _first_0 = COUNT346;
                    match(input, Token.DOWN, null); 
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:436:12: ( ASTERISK | ( DISTINCT | ALL ) countFunctionArguments )
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==ASTERISK) ) {
                        alt65=1;
                    }
                    else if ( (LA65_0==ALL||LA65_0==DISTINCT) ) {
                        alt65=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 0, input);

                        throw nvae;
                    }
                    switch (alt65) {
                        case 1 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:436:13: ASTERISK
                            {
                            _last = (CommonTree)input.LT(1);
                            ASTERISK347=(CommonTree)match(input,ASTERISK,FOLLOW_ASTERISK_in_setFunction2080); 
                             
                            if ( _first_1==null ) _first_1 = ASTERISK347;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;
                        case 2 :
                            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:436:24: ( DISTINCT | ALL ) countFunctionArguments
                            {
                            _last = (CommonTree)input.LT(1);
                            set348=(CommonTree)input.LT(1);
                            if ( input.LA(1)==ALL||input.LA(1)==DISTINCT ) {
                                input.consume();


                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_countFunctionArguments_in_setFunction2090);
                            countFunctionArguments349=countFunctionArguments();

                            state._fsp--;

                             
                            if ( _first_1==null ) _first_1 = countFunctionArguments349.tree;

                            retval.tree = (CommonTree)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                            }
                            break;

                    }


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "setFunction"

    public static class countFunctionArguments_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countFunctionArguments"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:439:1: countFunctionArguments : ( collectionExpression | propertyReference | numeric_literal );
    public final TestHQLTreeWalker.countFunctionArguments_return countFunctionArguments() throws RecognitionException {
        TestHQLTreeWalker.countFunctionArguments_return retval = new TestHQLTreeWalker.countFunctionArguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.collectionExpression_return collectionExpression350 = null;

        TestHQLTreeWalker.propertyReference_return propertyReference351 = null;

        TestHQLTreeWalker.numeric_literal_return numeric_literal352 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:440:2: ( collectionExpression | propertyReference | numeric_literal )
            int alt67=3;
            switch ( input.LA(1) ) {
            case ELEMENTS:
            case INDICES:
                {
                alt67=1;
                }
                break;
            case PROPERTY_REFERENCE:
                {
                alt67=2;
                }
                break;
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
                {
                alt67=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:440:4: collectionExpression
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_collectionExpression_in_countFunctionArguments2103);
                    collectionExpression350=collectionExpression();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = collectionExpression350.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:441:4: propertyReference
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_propertyReference_in_countFunctionArguments2108);
                    propertyReference351=propertyReference();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = propertyReference351.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:442:4: numeric_literal
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numeric_literal_in_countFunctionArguments2113);
                    numeric_literal352=numeric_literal();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = numeric_literal352.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "countFunctionArguments"

    public static class collectionFunction_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collectionFunction"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:445:1: collectionFunction : ^( ( MAXELEMENT | MAXINDEX | MINELEMENT | MININDEX ) collectionPropertyReference ) ;
    public final TestHQLTreeWalker.collectionFunction_return collectionFunction() throws RecognitionException {
        TestHQLTreeWalker.collectionFunction_return retval = new TestHQLTreeWalker.collectionFunction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set353=null;
        TestHQLTreeWalker.collectionPropertyReference_return collectionPropertyReference354 = null;


        CommonTree set353_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:446:2: ( ^( ( MAXELEMENT | MAXINDEX | MINELEMENT | MININDEX ) collectionPropertyReference ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:446:4: ^( ( MAXELEMENT | MAXINDEX | MINELEMENT | MININDEX ) collectionPropertyReference )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            set353=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=MAXELEMENT && input.LA(1)<=MAXINDEX)||(input.LA(1)>=MINELEMENT && input.LA(1)<=MININDEX) ) {
                input.consume();


                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            if ( _first_0==null ) _first_0 = set353;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_collectionPropertyReference_in_collectionFunction2135);
            collectionPropertyReference354=collectionPropertyReference();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = collectionPropertyReference354.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "collectionFunction"

    public static class collectionPropertyReference_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collectionPropertyReference"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:450:1: collectionPropertyReference : propertyReference ;
    public final TestHQLTreeWalker.collectionPropertyReference_return collectionPropertyReference() throws RecognitionException {
        TestHQLTreeWalker.collectionPropertyReference_return retval = new TestHQLTreeWalker.collectionPropertyReference_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        TestHQLTreeWalker.propertyReference_return propertyReference355 = null;



        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:451:2: ( propertyReference )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:451:4: propertyReference
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_propertyReference_in_collectionPropertyReference2150);
            propertyReference355=propertyReference();

            state._fsp--;

             
            if ( _first_0==null ) _first_0 = propertyReference355.tree;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "collectionPropertyReference"

    public static class collectionExpression_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collectionExpression"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:454:1: collectionExpression : ( ^( ELEMENTS propertyReference ) | ^( INDICES propertyReference ) );
    public final TestHQLTreeWalker.collectionExpression_return collectionExpression() throws RecognitionException {
        TestHQLTreeWalker.collectionExpression_return retval = new TestHQLTreeWalker.collectionExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ELEMENTS356=null;
        CommonTree INDICES358=null;
        TestHQLTreeWalker.propertyReference_return propertyReference357 = null;

        TestHQLTreeWalker.propertyReference_return propertyReference359 = null;


        CommonTree ELEMENTS356_tree=null;
        CommonTree INDICES358_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:455:2: ( ^( ELEMENTS propertyReference ) | ^( INDICES propertyReference ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==ELEMENTS) ) {
                alt68=1;
            }
            else if ( (LA68_0==INDICES) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:455:4: ^( ELEMENTS propertyReference )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    ELEMENTS356=(CommonTree)match(input,ELEMENTS,FOLLOW_ELEMENTS_in_collectionExpression2162); 


                    if ( _first_0==null ) _first_0 = ELEMENTS356;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_propertyReference_in_collectionExpression2164);
                    propertyReference357=propertyReference();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = propertyReference357.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:456:4: ^( INDICES propertyReference )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    INDICES358=(CommonTree)match(input,INDICES,FOLLOW_INDICES_in_collectionExpression2172); 


                    if ( _first_0==null ) _first_0 = INDICES358;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_propertyReference_in_collectionExpression2174);
                    propertyReference359=propertyReference();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = propertyReference359.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "collectionExpression"

    public static class parameter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:459:1: parameter : ( NAMED_PARAM | JPA_PARAM | PARAM );
    public final TestHQLTreeWalker.parameter_return parameter() throws RecognitionException {
        TestHQLTreeWalker.parameter_return retval = new TestHQLTreeWalker.parameter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set360=null;

        CommonTree set360_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:460:2: ( NAMED_PARAM | JPA_PARAM | PARAM )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:
            {
            _last = (CommonTree)input.LT(1);
            set360=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=JPA_PARAM && input.LA(1)<=NAMED_PARAM)||input.LA(1)==PARAM ) {
                input.consume();


                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parameter"

    public static class constant_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:465:1: constant : ( literal | NULL | TRUE | FALSE );
    public final TestHQLTreeWalker.constant_return constant() throws RecognitionException {
        TestHQLTreeWalker.constant_return retval = new TestHQLTreeWalker.constant_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NULL362=null;
        CommonTree TRUE363=null;
        CommonTree FALSE364=null;
        TestHQLTreeWalker.literal_return literal361 = null;


        CommonTree NULL362_tree=null;
        CommonTree TRUE363_tree=null;
        CommonTree FALSE364_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:466:2: ( literal | NULL | TRUE | FALSE )
            int alt69=4;
            switch ( input.LA(1) ) {
            case HEX_LITERAL:
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
            case OCTAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
                {
                alt69=1;
                }
                break;
            case NULL:
                {
                alt69=2;
                }
                break;
            case TRUE:
                {
                alt69=3;
                }
                break;
            case FALSE:
                {
                alt69=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:466:4: literal
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_literal_in_constant2207);
                    literal361=literal();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = literal361.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:467:4: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL362=(CommonTree)match(input,NULL,FOLLOW_NULL_in_constant2212); 
                     
                    if ( _first_0==null ) _first_0 = NULL362;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:468:4: TRUE
                    {
                    _last = (CommonTree)input.LT(1);
                    TRUE363=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_constant2217); 
                     
                    if ( _first_0==null ) _first_0 = TRUE363;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:469:4: FALSE
                    {
                    _last = (CommonTree)input.LT(1);
                    FALSE364=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_constant2222); 
                     
                    if ( _first_0==null ) _first_0 = FALSE364;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constant"

    public static class literal_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:472:1: literal : ( numeric_literal | HEX_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL );
    public final TestHQLTreeWalker.literal_return literal() throws RecognitionException {
        TestHQLTreeWalker.literal_return retval = new TestHQLTreeWalker.literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree HEX_LITERAL366=null;
        CommonTree OCTAL_LITERAL367=null;
        CommonTree CHARACTER_LITERAL368=null;
        CommonTree STRING_LITERAL369=null;
        TestHQLTreeWalker.numeric_literal_return numeric_literal365 = null;


        CommonTree HEX_LITERAL366_tree=null;
        CommonTree OCTAL_LITERAL367_tree=null;
        CommonTree CHARACTER_LITERAL368_tree=null;
        CommonTree STRING_LITERAL369_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:473:2: ( numeric_literal | HEX_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL )
            int alt70=5;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
                {
                alt70=1;
                }
                break;
            case HEX_LITERAL:
                {
                alt70=2;
                }
                break;
            case OCTAL_LITERAL:
                {
                alt70=3;
                }
                break;
            case CHARACTER_LITERAL:
                {
                alt70=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt70=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:473:4: numeric_literal
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_numeric_literal_in_literal2233);
                    numeric_literal365=numeric_literal();

                    state._fsp--;

                     
                    if ( _first_0==null ) _first_0 = numeric_literal365.tree;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:474:4: HEX_LITERAL
                    {
                    _last = (CommonTree)input.LT(1);
                    HEX_LITERAL366=(CommonTree)match(input,HEX_LITERAL,FOLLOW_HEX_LITERAL_in_literal2238); 
                     
                    if ( _first_0==null ) _first_0 = HEX_LITERAL366;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:475:4: OCTAL_LITERAL
                    {
                    _last = (CommonTree)input.LT(1);
                    OCTAL_LITERAL367=(CommonTree)match(input,OCTAL_LITERAL,FOLLOW_OCTAL_LITERAL_in_literal2243); 
                     
                    if ( _first_0==null ) _first_0 = OCTAL_LITERAL367;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:476:4: CHARACTER_LITERAL
                    {
                    _last = (CommonTree)input.LT(1);
                    CHARACTER_LITERAL368=(CommonTree)match(input,CHARACTER_LITERAL,FOLLOW_CHARACTER_LITERAL_in_literal2248); 
                     
                    if ( _first_0==null ) _first_0 = CHARACTER_LITERAL368;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 5 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:477:4: STRING_LITERAL
                    {
                    _last = (CommonTree)input.LT(1);
                    STRING_LITERAL369=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal2253); 
                     
                    if ( _first_0==null ) _first_0 = STRING_LITERAL369;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    public static class numeric_literal_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numeric_literal"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:480:1: numeric_literal : ( INTEGER_LITERAL | DECIMAL_LITERAL | FLOATING_POINT_LITERAL );
    public final TestHQLTreeWalker.numeric_literal_return numeric_literal() throws RecognitionException {
        TestHQLTreeWalker.numeric_literal_return retval = new TestHQLTreeWalker.numeric_literal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set370=null;

        CommonTree set370_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:481:2: ( INTEGER_LITERAL | DECIMAL_LITERAL | FLOATING_POINT_LITERAL )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:
            {
            _last = (CommonTree)input.LT(1);
            set370=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=INTEGER_LITERAL && input.LA(1)<=DECIMAL_LITERAL)||input.LA(1)==FLOATING_POINT_LITERAL ) {
                input.consume();


                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "numeric_literal"

    public static class entityName_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "entityName"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:486:1: entityName : ENTITY_NAME ALIAS_NAME ;
    public final TestHQLTreeWalker.entityName_return entityName() throws RecognitionException {
        TestHQLTreeWalker.entityName_return retval = new TestHQLTreeWalker.entityName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ENTITY_NAME371=null;
        CommonTree ALIAS_NAME372=null;

        CommonTree ENTITY_NAME371_tree=null;
        CommonTree ALIAS_NAME372_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:487:2: ( ENTITY_NAME ALIAS_NAME )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:487:4: ENTITY_NAME ALIAS_NAME
            {
            _last = (CommonTree)input.LT(1);
            ENTITY_NAME371=(CommonTree)match(input,ENTITY_NAME,FOLLOW_ENTITY_NAME_in_entityName2285); 
             
            if ( _first_0==null ) _first_0 = ENTITY_NAME371;
            _last = (CommonTree)input.LT(1);
            ALIAS_NAME372=(CommonTree)match(input,ALIAS_NAME,FOLLOW_ALIAS_NAME_in_entityName2287); 
             
            if ( _first_0==null ) _first_0 = ALIAS_NAME372;

            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "entityName"

    public static class propertyReference_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyReference"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:490:1: propertyReference : ^( PROPERTY_REFERENCE identPrimary ) ;
    public final TestHQLTreeWalker.propertyReference_return propertyReference() throws RecognitionException {
        TestHQLTreeWalker.propertyReference_return retval = new TestHQLTreeWalker.propertyReference_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PROPERTY_REFERENCE373=null;
        TestHQLTreeWalker.identPrimary_return identPrimary374 = null;


        CommonTree PROPERTY_REFERENCE373_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:491:2: ( ^( PROPERTY_REFERENCE identPrimary ) )
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:491:4: ^( PROPERTY_REFERENCE identPrimary )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            _last = (CommonTree)input.LT(1);
            PROPERTY_REFERENCE373=(CommonTree)match(input,PROPERTY_REFERENCE,FOLLOW_PROPERTY_REFERENCE_in_propertyReference2299); 


            if ( _first_0==null ) _first_0 = PROPERTY_REFERENCE373;
            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_identPrimary_in_propertyReference2301);
            identPrimary374=identPrimary();

            state._fsp--;

             
            if ( _first_1==null ) _first_1 = identPrimary374.tree;

            match(input, Token.UP, null); _last = _save_last_1;
            }


            retval.tree = (CommonTree)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (CommonTree)adaptor.getParent(retval.tree);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "propertyReference"

    public static class identPrimary_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identPrimary"
    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:494:1: identPrimary : ( IDENTIFIER | ^( DOT identPrimary identPrimary ) | ^( LEFT_SQUARE identPrimary ( valueExpression )* ) | ^( LEFT_PAREN identPrimary ( valueExpression )* ) );
    public final TestHQLTreeWalker.identPrimary_return identPrimary() throws RecognitionException {
        TestHQLTreeWalker.identPrimary_return retval = new TestHQLTreeWalker.identPrimary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER375=null;
        CommonTree DOT376=null;
        CommonTree LEFT_SQUARE379=null;
        CommonTree LEFT_PAREN382=null;
        TestHQLTreeWalker.identPrimary_return identPrimary377 = null;

        TestHQLTreeWalker.identPrimary_return identPrimary378 = null;

        TestHQLTreeWalker.identPrimary_return identPrimary380 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression381 = null;

        TestHQLTreeWalker.identPrimary_return identPrimary383 = null;

        TestHQLTreeWalker.valueExpression_return valueExpression384 = null;


        CommonTree IDENTIFIER375_tree=null;
        CommonTree DOT376_tree=null;
        CommonTree LEFT_SQUARE379_tree=null;
        CommonTree LEFT_PAREN382_tree=null;

        try {
            // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:495:2: ( IDENTIFIER | ^( DOT identPrimary identPrimary ) | ^( LEFT_SQUARE identPrimary ( valueExpression )* ) | ^( LEFT_PAREN identPrimary ( valueExpression )* ) )
            int alt73=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt73=1;
                }
                break;
            case DOT:
                {
                alt73=2;
                }
                break;
            case LEFT_SQUARE:
                {
                alt73=3;
                }
                break;
            case LEFT_PAREN:
                {
                alt73=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:495:5: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER375=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identPrimary2314); 
                     
                    if ( _first_0==null ) _first_0 = IDENTIFIER375;

                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 2 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:496:4: ^( DOT identPrimary identPrimary )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    DOT376=(CommonTree)match(input,DOT,FOLLOW_DOT_in_identPrimary2320); 


                    if ( _first_0==null ) _first_0 = DOT376;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_identPrimary_in_identPrimary2322);
                    identPrimary377=identPrimary();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = identPrimary377.tree;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_identPrimary_in_identPrimary2324);
                    identPrimary378=identPrimary();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = identPrimary378.tree;

                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 3 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:497:4: ^( LEFT_SQUARE identPrimary ( valueExpression )* )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    LEFT_SQUARE379=(CommonTree)match(input,LEFT_SQUARE,FOLLOW_LEFT_SQUARE_in_identPrimary2332); 


                    if ( _first_0==null ) _first_0 = LEFT_SQUARE379;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_identPrimary_in_identPrimary2334);
                    identPrimary380=identPrimary();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = identPrimary380.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:497:31: ( valueExpression )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==ALIAS_REF||LA71_0==DOT_CLASS||(LA71_0>=JAVA_CONSTANT && LA71_0<=NAMED_PARAM)||LA71_0==PATH||LA71_0==PROPERTY_REFERENCE||LA71_0==SEARCHED_CASE||LA71_0==SIMPLE_CASE||(LA71_0>=SUB_QUERY && LA71_0<=VECTOR_EXPR)||(LA71_0>=ABS && LA71_0<=ALL)||LA71_0==ANY||LA71_0==AVG||LA71_0==BIT_LENGTH||(LA71_0>=CAST && LA71_0<=CHARACTER_LENGTH)||(LA71_0>=COALESCE && LA71_0<=COUNT)||(LA71_0>=CURRENT_DATE && LA71_0<=CURRENT_TIMESTAMP)||LA71_0==ELEMENTS||(LA71_0>=EXISTS && LA71_0<=EXTRACT)||(LA71_0>=INDEX && LA71_0<=INDICES)||LA71_0==LENGTH||(LA71_0>=LOCATE && LA71_0<=MAXINDEX)||(LA71_0>=MIN && LA71_0<=MININDEX)||LA71_0==MOD||(LA71_0>=NULLIF && LA71_0<=OCTET_LENGTH)||LA71_0==POSITION||(LA71_0>=SIZE && LA71_0<=SUM)||LA71_0==TRIM||LA71_0==UPPER||(LA71_0>=HEX_LITERAL && LA71_0<=OCTAL_LITERAL)||LA71_0==FLOATING_POINT_LITERAL||(LA71_0>=CHARACTER_LITERAL && LA71_0<=STRING_LITERAL)||(LA71_0>=TRUE && LA71_0<=NULL)||(LA71_0>=DOUBLE_PIPE && LA71_0<=PARAM)||(LA71_0>=PLUS && LA71_0<=SOLIDUS)||LA71_0==GENERAL_FUNCTION_CALL) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:497:31: valueExpression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_valueExpression_in_identPrimary2336);
                    	    valueExpression381=valueExpression();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = valueExpression381.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;
                case 4 :
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:498:4: ^( LEFT_PAREN identPrimary ( valueExpression )* )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    _last = (CommonTree)input.LT(1);
                    LEFT_PAREN382=(CommonTree)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_identPrimary2345); 


                    if ( _first_0==null ) _first_0 = LEFT_PAREN382;
                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_identPrimary_in_identPrimary2347);
                    identPrimary383=identPrimary();

                    state._fsp--;

                     
                    if ( _first_1==null ) _first_1 = identPrimary383.tree;
                    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:498:30: ( valueExpression )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==ALIAS_REF||LA72_0==DOT_CLASS||(LA72_0>=JAVA_CONSTANT && LA72_0<=NAMED_PARAM)||LA72_0==PATH||LA72_0==PROPERTY_REFERENCE||LA72_0==SEARCHED_CASE||LA72_0==SIMPLE_CASE||(LA72_0>=SUB_QUERY && LA72_0<=VECTOR_EXPR)||(LA72_0>=ABS && LA72_0<=ALL)||LA72_0==ANY||LA72_0==AVG||LA72_0==BIT_LENGTH||(LA72_0>=CAST && LA72_0<=CHARACTER_LENGTH)||(LA72_0>=COALESCE && LA72_0<=COUNT)||(LA72_0>=CURRENT_DATE && LA72_0<=CURRENT_TIMESTAMP)||LA72_0==ELEMENTS||(LA72_0>=EXISTS && LA72_0<=EXTRACT)||(LA72_0>=INDEX && LA72_0<=INDICES)||LA72_0==LENGTH||(LA72_0>=LOCATE && LA72_0<=MAXINDEX)||(LA72_0>=MIN && LA72_0<=MININDEX)||LA72_0==MOD||(LA72_0>=NULLIF && LA72_0<=OCTET_LENGTH)||LA72_0==POSITION||(LA72_0>=SIZE && LA72_0<=SUM)||LA72_0==TRIM||LA72_0==UPPER||(LA72_0>=HEX_LITERAL && LA72_0<=OCTAL_LITERAL)||LA72_0==FLOATING_POINT_LITERAL||(LA72_0>=CHARACTER_LITERAL && LA72_0<=STRING_LITERAL)||(LA72_0>=TRUE && LA72_0<=NULL)||(LA72_0>=DOUBLE_PIPE && LA72_0<=PARAM)||(LA72_0>=PLUS && LA72_0<=SOLIDUS)||LA72_0==GENERAL_FUNCTION_CALL) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // /home/sanne/workspaces/hibernate/hibernate-search-root/hibernate-search-hql/src/test/antlr3/org/hibernate/sql/ast/origin/hql/parse/TestHQLTreeWalker.g:498:30: valueExpression
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_valueExpression_in_identPrimary2349);
                    	    valueExpression384=valueExpression();

                    	    state._fsp--;

                    	     
                    	    if ( _first_1==null ) _first_1 = valueExpression384.tree;

                    	    retval.tree = (CommonTree)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);


                    match(input, Token.UP, null); _last = _save_last_1;
                    }


                    retval.tree = (CommonTree)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (CommonTree)adaptor.getParent(retval.tree);
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identPrimary"

    // Delegated rules


 

    public static final BitSet FOLLOW_QUERY_in_filterStatement56 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUERY_SPEC_in_filterStatement59 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FILTER_in_filterStatement61 = new BitSet(new long[]{0x0000000000000008L,0x4100000000200000L,0x0000000000008000L});
    public static final BitSet FOLLOW_selectClause_in_filterStatement68 = new BitSet(new long[]{0x0000000000000008L,0x0100000000200000L,0x0000000000008000L});
    public static final BitSet FOLLOW_whereClause_in_filterStatement71 = new BitSet(new long[]{0x0000000000000008L,0x0100000000200000L});
    public static final BitSet FOLLOW_groupByClause_in_filterStatement76 = new BitSet(new long[]{0x0000000000000008L,0x0100000000400000L});
    public static final BitSet FOLLOW_havingClause_in_filterStatement78 = new BitSet(new long[]{0x0000000000000008L,0x0100000000000000L});
    public static final BitSet FOLLOW_orderByClause_in_filterStatement83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_updateStatementSet_in_statement97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatementSet_in_statement102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatementSet_in_statement107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_queryStatementSet_in_statement112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_updateStatementSet123 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_UPDATE_in_updateStatement136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_entityName_in_updateStatement138 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_SET_in_updateStatement141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_updateStatement143 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_whereClause_in_updateStatement147 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_assignment161 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyReference_in_assignment163 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_assignment165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALS_in_assignment172 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VERSIONED_VALUE_in_assignment174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_assignment176 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_deleteStatement_in_deleteStatementSet188 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_DELETE_in_deleteStatement201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_entityName_in_deleteStatement203 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_whereClause_in_deleteStatement205 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_insertStatement_in_insertStatementSet218 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_INSERT_in_insertStatement231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_intoClause_in_insertStatement233 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_queryStatementSet_in_insertStatement235 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTO_in_intoClause248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_entityName_in_intoClause250 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_INSERTABILITY_SPEC_in_intoClause253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyReference_in_intoClause255 = new BitSet(new long[]{0x0000004000000008L});
    public static final BitSet FOLLOW_queryStatement_in_queryStatementSet271 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_QUERY_in_queryStatement284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_queryExpression_in_queryStatement286 = new BitSet(new long[]{0x0000000000000008L,0x0100000000000000L});
    public static final BitSet FOLLOW_orderByClause_in_queryStatement288 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNION_in_queryExpression302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALL_in_queryExpression304 = new BitSet(new long[]{0x0000010000000000L,0x0000000020008000L,0x0000000000000400L});
    public static final BitSet FOLLOW_queryExpression_in_queryExpression307 = new BitSet(new long[]{0x0000010000000000L,0x0000000020008000L,0x0000000000000400L});
    public static final BitSet FOLLOW_queryExpression_in_queryExpression309 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTERSECT_in_queryExpression316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALL_in_queryExpression318 = new BitSet(new long[]{0x0000010000000000L,0x0000000020008000L,0x0000000000000400L});
    public static final BitSet FOLLOW_queryExpression_in_queryExpression321 = new BitSet(new long[]{0x0000010000000000L,0x0000000020008000L,0x0000000000000400L});
    public static final BitSet FOLLOW_queryExpression_in_queryExpression323 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXCEPT_in_queryExpression330 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALL_in_queryExpression332 = new BitSet(new long[]{0x0000010000000000L,0x0000000020008000L,0x0000000000000400L});
    public static final BitSet FOLLOW_queryExpression_in_queryExpression335 = new BitSet(new long[]{0x0000010000000000L,0x0000000020008000L,0x0000000000000400L});
    public static final BitSet FOLLOW_queryExpression_in_queryExpression337 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_querySpec_in_queryExpression343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_SPEC_in_querySpec356 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_selectFrom_in_querySpec358 = new BitSet(new long[]{0x0000000000000008L,0x0000000000600000L,0x0000000000008000L});
    public static final BitSet FOLLOW_whereClause_in_querySpec360 = new BitSet(new long[]{0x0000000000000008L,0x0000000000600000L});
    public static final BitSet FOLLOW_groupByClause_in_querySpec363 = new BitSet(new long[]{0x0000000000000008L,0x0000000000400000L});
    public static final BitSet FOLLOW_havingClause_in_querySpec366 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHERE_in_whereClause380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchCondition_in_whereClause382 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GROUP_BY_in_groupByClause395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_groupingValue_in_groupByClause397 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_GROUPING_VALUE_in_groupingValue411 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_groupingValue413 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_COLLATE_in_groupingValue415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_HAVING_in_havingClause429 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchCondition_in_havingClause431 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SELECT_FROM_in_selectFrom444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_fromClause_in_selectFrom446 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_selectClause_in_selectFrom448 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FROM_in_fromClause461 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_persisterSpaces_in_fromClause463 = new BitSet(new long[]{0x0000000800000008L});
    public static final BitSet FOLLOW_PERSISTER_SPACE_in_persisterSpaces477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_persisterSpace_in_persisterSpaces479 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_persisterSpaceRoot_in_persisterSpace491 = new BitSet(new long[]{0x0000002400000002L});
    public static final BitSet FOLLOW_joins_in_persisterSpace493 = new BitSet(new long[]{0x0000002400000002L});
    public static final BitSet FOLLOW_ENTITY_PERSISTER_REF_in_persisterSpaceRoot506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_entityName_in_persisterSpaceRoot508 = new BitSet(new long[]{0x0000001000000008L});
    public static final BitSet FOLLOW_PROP_FETCH_in_persisterSpaceRoot510 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROPERTY_JOIN_in_joins524 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_joinType_in_joins526 = new BitSet(new long[]{0x0000000000000080L,0x0000000000040000L});
    public static final BitSet FOLLOW_FETCH_in_joins528 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ALIAS_NAME_in_joins531 = new BitSet(new long[]{0x0000005000000000L,0x0000000004000800L});
    public static final BitSet FOLLOW_PROP_FETCH_in_joins533 = new BitSet(new long[]{0x0000004000000000L,0x0000000004000800L});
    public static final BitSet FOLLOW_collectionExpression_in_joins537 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_propertyReference_in_joins539 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_withClause_in_joins542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERSISTER_JOIN_in_joins550 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_joinType_in_joins552 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_persisterSpaceRoot_in_joins554 = new BitSet(new long[]{0x0000000000000008L,0x0040000000000000L});
    public static final BitSet FOLLOW_onClause_in_joins556 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WITH_in_withClause570 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchCondition_in_withClause572 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ON_in_onClause585 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchCondition_in_onClause587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_joinType599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_joinType604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_joinType609 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
    public static final BitSet FOLLOW_OUTER_in_joinType621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_selectClause634 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DISTINCT_in_selectClause636 = new BitSet(new long[]{0xD56F74420E007100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_rootSelectExpression_in_selectClause639 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SELECT_LIST_in_rootSelectExpression653 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rootSelectExpression_in_rootSelectExpression655 = new BitSet(new long[]{0xD56F74420E007108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_SELECT_ITEM_in_rootSelectExpression663 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rootSelectExpression_in_rootSelectExpression665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DYNAMIC_INSTANTIATION_in_rootSelectExpression672 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rootSelectExpression_in_rootSelectExpression674 = new BitSet(new long[]{0xD56F74420E007108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_DYNAMIC_INSTANTIATION_ARG_in_rootSelectExpression682 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rootSelectExpression_in_rootSelectExpression684 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_valueExpression_in_rootSelectExpression690 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ALIAS_NAME_in_rootSelectExpression692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_BY_in_orderByClause705 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sortSpecification_in_orderByClause707 = new BitSet(new long[]{0x0000800000000008L});
    public static final BitSet FOLLOW_SORT_SPEC_in_sortSpecification721 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_sortSpecification723 = new BitSet(new long[]{0x0000000100000400L});
    public static final BitSet FOLLOW_COLLATE_in_sortSpecification725 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ORDER_SPEC_in_sortSpecification728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_searchCondition742 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchCondition_in_searchCondition744 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_searchCondition_in_searchCondition746 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_searchCondition755 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchCondition_in_searchCondition757 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_searchCondition_in_searchCondition759 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_searchCondition768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchCondition_in_searchCondition770 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_predicate_in_searchCondition777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_predicate790 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate792 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_comparativePredicateValue_in_predicate794 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_predicate803 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate805 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_comparativePredicateValue_in_predicate807 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESS_in_predicate816 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate818 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_comparativePredicateValue_in_predicate820 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESS_EQUAL_in_predicate829 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate831 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_comparativePredicateValue_in_predicate833 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_in_predicate842 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate844 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_comparativePredicateValue_in_predicate846 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_EQUAL_in_predicate855 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate857 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_comparativePredicateValue_in_predicate859 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IS_NULL_in_predicate868 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate870 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IS_NOT_NULL_in_predicate879 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate881 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIKE_in_predicate890 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_predicate892 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_predicate894 = new BitSet(new long[]{0x0000000000000008L,0x0000000000004000L});
    public static final BitSet FOLLOW_escapeSpecification_in_predicate896 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_LIKE_in_predicate906 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_predicate908 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_predicate910 = new BitSet(new long[]{0x0000000000000008L,0x0000000000004000L});
    public static final BitSet FOLLOW_escapeSpecification_in_predicate912 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BETWEEN_in_predicate922 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate924 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_betweenList_in_predicate926 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_BETWEEN_in_predicate935 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate937 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_betweenList_in_predicate939 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_predicate948 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate950 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_inPredicateValue_in_predicate952 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_IN_in_predicate961 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate963 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_inPredicateValue_in_predicate965 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MEMBER_OF_in_predicate974 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate976 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate978 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_MEMBER_OF_in_predicate987 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate989 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate991 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IS_EMPTY_in_predicate1001 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate1003 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IS_NOT_EMPTY_in_predicate1012 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate1014 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rowValueConstructor_in_predicate1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BETWEEN_LIST_in_betweenList1034 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_betweenList1036 = new BitSet(new long[]{0xDDEF4442FFC01100L,0x04B97FF0870308EEL,0x9E00FD3CD3C0121FL});
    public static final BitSet FOLLOW_rowValueConstructor_in_betweenList1038 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rowValueConstructor_in_comparativePredicateValue1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueExpression_in_rowValueConstructor1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ESCAPE_in_escapeSpecification1075 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_escapeSpecification1077 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_LIST_in_inPredicateValue1090 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_inPredicateValue1092 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_numericValueExpression1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueExpression_in_characterValueExpression1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueExpression_in_datetimeValueExpression1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_PIPE_in_valueExpression1140 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_valueExpression1142 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_UNARY_MINUS_in_valueExpression1152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_valueExpression1154 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_PLUS_in_valueExpression1163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_valueExpression1165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_valueExpression1174 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_valueExpression1176 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_valueExpression1178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_valueExpression1187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_valueExpression1189 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_valueExpression1191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASTERISK_in_valueExpression1200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_valueExpression1202 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_numericValueExpression_in_valueExpression1204 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOLIDUS_in_valueExpression1213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_valueExpression1215 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_numericValueExpression_in_valueExpression1217 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXISTS_in_valueExpression1226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowValueConstructor_in_valueExpression1228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOME_in_valueExpression1239 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_valueExpression1241 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALL_in_valueExpression1253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_valueExpression1255 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ANY_in_valueExpression1267 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_valueExpression1269 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VECTOR_EXPR_in_valueExpression1278 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_valueExpression1280 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpressionPrimary_in_valueExpression1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseExpression_in_valueExpressionPrimary1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_valueExpressionPrimary1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionFunction_in_valueExpressionPrimary1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectionExpression_in_valueExpressionPrimary1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_valueExpressionPrimary1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_valueExpressionPrimary1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyReference_in_valueExpressionPrimary1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_QUERY_in_valueExpressionPrimary1335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_queryStatementSet_in_valueExpressionPrimary1337 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALIAS_REF_in_valueExpressionPrimary1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_CLASS_in_valueExpressionPrimary1350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_identPrimary_in_valueExpressionPrimary1352 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERAL_FUNCTION_CALL_in_valueExpressionPrimary1360 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_identPrimary_in_valueExpressionPrimary1362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_JAVA_CONSTANT_in_valueExpressionPrimary1369 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_identPrimary_in_valueExpressionPrimary1371 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PATH_in_valueExpressionPrimary1379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_identPrimary_in_valueExpressionPrimary1381 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULLIF_in_caseExpression1394 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_caseExpression1396 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_caseExpression1398 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COALESCE_in_caseExpression1405 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_caseExpression1407 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_caseExpression1409 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_SIMPLE_CASE_in_caseExpression1417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_caseExpression1419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_simpleCaseWhenClause_in_caseExpression1421 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L,0x0000000000004000L});
    public static final BitSet FOLLOW_elseClause_in_caseExpression1424 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEARCHED_CASE_in_caseExpression1432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchedWhenClause_in_caseExpression1434 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L,0x0000000000004000L});
    public static final BitSet FOLLOW_elseClause_in_caseExpression1437 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHEN_in_simpleCaseWhenClause1451 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_simpleCaseWhenClause1453 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_simpleCaseWhenClause1455 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHEN_in_searchedWhenClause1468 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_searchCondition_in_searchedWhenClause1470 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_searchedWhenClause1472 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseClause1485 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_elseClause1487 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_standardFunction_in_function1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setFunction_in_function1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castFunction_in_standardFunction1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatFunction_in_standardFunction1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_substringFunction_in_standardFunction1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trimFunction_in_standardFunction1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_upperFunction_in_standardFunction1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lowerFunction_in_standardFunction1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lengthFunction_in_standardFunction1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_locateFunction_in_standardFunction1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_absFunction_in_standardFunction1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqrtFunction_in_standardFunction1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modFunction_in_standardFunction1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sizeFunction_in_standardFunction1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indexFunction_in_standardFunction1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_currentDateFunction_in_standardFunction1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_currentTimeFunction_in_standardFunction1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_currentTimestampFunction_in_standardFunction1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extractFunction_in_standardFunction1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_positionFunction_in_standardFunction1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charLengthFunction_in_standardFunction1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_octetLengthFunction_in_standardFunction1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bitLengthFunction_in_standardFunction1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_in_castFunction1627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_castFunction1629 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_castFunction1631 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CONCAT_in_concatFunction1644 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valueExpression_in_concatFunction1646 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_SUBSTRING_in_substringFunction1660 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_substringFunction1662 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_numericValueExpression_in_substringFunction1664 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_numericValueExpression_in_substringFunction1666 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TRIM_in_trimFunction1680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_trimOperands_in_trimFunction1682 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_trimOperands1695 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_trimOperands1703 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_characterValueExpression_in_trimOperands1705 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UPPER_in_upperFunction1718 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_upperFunction1720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOWER_in_lowerFunction1733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_lowerFunction1735 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LENGTH_in_lengthFunction1748 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_lengthFunction1750 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCATE_in_locateFunction1763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_locateFunction1765 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_characterValueExpression_in_locateFunction1767 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_numericValueExpression_in_locateFunction1769 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ABS_in_absFunction1783 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_absFunction1785 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SQRT_in_sqrtFunction1798 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_sqrtFunction1800 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_modFunction1813 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_modFunction1815 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_numericValueExpression_in_modFunction1817 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SIZE_in_sizeFunction1830 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyReference_in_sizeFunction1832 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDEX_in_indexFunction1845 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALIAS_REF_in_indexFunction1847 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CURRENT_DATE_in_currentDateFunction1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_TIME_in_currentTimeFunction1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_TIMESTAMP_in_currentTimestampFunction1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTRACT_in_extractFunction1893 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_extractField_in_extractFunction1895 = new BitSet(new long[]{0xD56F44420E001100L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_datetimeValueExpression_in_extractFunction1897 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_datetimeField_in_extractField1909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timeZoneField_in_extractField1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_datetimeField0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_timeZoneField0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITION_in_positionFunction1978 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_positionFunction1980 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_characterValueExpression_in_positionFunction1982 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHARACTER_LENGTH_in_charLengthFunction1995 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_charLengthFunction1997 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OCTET_LENGTH_in_octetLengthFunction2010 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_octetLengthFunction2012 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIT_LENGTH_in_bitLengthFunction2026 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_characterValueExpression_in_bitLengthFunction2028 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SUM_in_setFunction2041 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_setFunction2043 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AVG_in_setFunction2050 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_setFunction2052 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAX_in_setFunction2059 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_setFunction2061 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MIN_in_setFunction2068 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_numericValueExpression_in_setFunction2070 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COUNT_in_setFunction2077 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ASTERISK_in_setFunction2080 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_setFunction2084 = new BitSet(new long[]{0x0000004000000000L,0x0000000004000800L,0x0000000011800000L});
    public static final BitSet FOLLOW_countFunctionArguments_in_setFunction2090 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_collectionExpression_in_countFunctionArguments2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyReference_in_countFunctionArguments2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_literal_in_countFunctionArguments2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_collectionFunction2125 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_collectionPropertyReference_in_collectionFunction2135 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_propertyReference_in_collectionPropertyReference2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENTS_in_collectionExpression2162 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyReference_in_collectionExpression2164 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDICES_in_collectionExpression2172 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_propertyReference_in_collectionExpression2174 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_parameter0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_constant2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_constant2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_constant2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_constant2222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_literal_in_literal2233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_LITERAL_in_literal2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_LITERAL_in_literal2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_LITERAL_in_literal2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_numeric_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTITY_NAME_in_entityName2285 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ALIAS_NAME_in_entityName2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPERTY_REFERENCE_in_propertyReference2299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_identPrimary_in_propertyReference2301 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identPrimary2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identPrimary2320 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_identPrimary_in_identPrimary2322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x012A000000000000L});
    public static final BitSet FOLLOW_identPrimary_in_identPrimary2324 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEFT_SQUARE_in_identPrimary2332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_identPrimary_in_identPrimary2334 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_identPrimary2336 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_LEFT_PAREN_in_identPrimary2345 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_identPrimary_in_identPrimary2347 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});
    public static final BitSet FOLLOW_valueExpression_in_identPrimary2349 = new BitSet(new long[]{0xD56F44420E001108L,0x043177D0060308EEL,0x9E000C1CD3C0121FL});

}