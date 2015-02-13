package com.example.heuvell.exceptions;

/**
 * Created by HeuvelL on 12-2-2015.
 */

  /*
    2    * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
    3    * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
    4    *
    5    * This code is free software; you can redistribute it and/or modify it
    6    * under the terms of the GNU General Public License version 2 only, as
    7    * published by the Free Software Foundation.  Oracle designates this
    8    * particular file as subject to the "Classpath" exception as provided
    9    * by Oracle in the LICENSE file that accompanied this code.
   10    *
   11    * This code is distributed in the hope that it will be useful, but WITHOUT
   12    * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
   13    * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
   14    * version 2 for more details (a copy is included in the LICENSE file that
   15    * accompanied this code).
   16    *
   17    * You should have received a copy of the GNU General Public License version
   18    * 2 along with this work; if not, write to the Free Software Foundation,
   19    * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
   20    *
   21    * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
   22    * or visit www.oracle.com if you need additional information or have any
   23    * questions.
   24    */
    /**
 29    * The subclass of {@link java.sql.SQLException} thrown when an instance where a retry
 30    * of the same operation would fail unless the cause of the <code>SQLException</code>
 31    * is corrected.
 32    *<p>
 33    *
 34    * @since 1.6
 35    */
           public class SQLNonTransientException extends java.sql.SQLException {

                      /**
     39            * Constructs a <code>SQLNonTransientException</code> object.
     40            *  The <code>reason</code>, <code>SQLState</code> are initialized
     41            * to <code>null</code> and the vendor code is initialized to 0.
     42            *
     43            * The <code>cause</code> is not initialized, and may subsequently be
     44            * initialized by a call to the
     45            * {@link Throwable#initCause(java.lang.Throwable)} method.
     46            * <p>
     47            *
     48            * @since 1.6
     49            */
                       public SQLNonTransientException() {
                  super();
                  }

                      /**
     55            * Constructs a <code>SQLNonTransientException</code> object
     56            * with a given <code>reason</code>. The <code>SQLState</code>
     57            * is initialized to <code>null</code> and the vender code is initialized
     58            * to 0.
     59            *
     60            * The <code>cause</code> is not initialized, and may subsequently be
     61            * initialized by a call to the
     62            * {@link Throwable#initCause(java.lang.Throwable)} method.
     63            * <p>
     64            *
     65            * @param reason a description of the exception
     66            * @since 1.6
     67            */
                      public SQLNonTransientException(String reason) {
                         super(reason);
                 }

                      /**
     73            * Constructs a <code>SQLNonTransientException</code> object
     74            * with a given <code>reason</code> and <code>SQLState</code>.
     75            *
     76            * The <code>cause</code> is not initialized, and may subsequently be
     77            * initialized by a call to the
     78            * {@link Throwable#initCause(java.lang.Throwable)} method. The vendor code
     79            * is initialized to 0.
     80            * <p>
     81            * @param reason a description of the exception
     82            * @param SQLState an XOPEN or SQL:2003 code identifying the exception
     83            * @since 1.6
     84            */
                      public SQLNonTransientException(String reason, String SQLState) {
                          super(reason,SQLState);
                  }

                      /**
     90            * Constructs a <code>SQLNonTransientException</code> object
     91            * with a given <code>reason</code>, <code>SQLState</code>  and
     92            * <code>vendorCode</code>.
     93            *
     94            * The <code>cause</code> is not initialized, and may subsequently be
     95            * initialized by a call to the
     96            * {@link Throwable#initCause(java.lang.Throwable)} method.
     97            * <p>
     98            * @param reason a description of the exception
     99            * @param SQLState an XOPEN or SQL:2003 code identifying the exception
     100            * @param vendorCode a database vendor specific exception code
     101            * @since 1.6
     102            */
                      public SQLNonTransientException(String reason, String SQLState, int vendorCode) {
                            super(reason,SQLState,vendorCode);
                   }

                   /**
     108        * Constructs a <code>SQLNonTransientException</code> object
     109        *  with a given  <code>cause</code>.
     110        * The <code>SQLState</code> is initialized
     111        * to <code>null</code> and the vendor code is initialized to 0.
     112        * The <code>reason</code>  is initialized to <code>null</code> if
     113        * <code>cause==null</code> or to <code>cause.toString()</code> if
     114        * <code>cause!=null</code>.
     115        * <p>
     116        * @param cause the underlying reason for this <code>SQLException</code> (which is saved for later retrieval by the <code>getCause()</code> method); may be null indicating
     117        *     the cause is non-existent or unknown.
     118        * @since 1.6
     119        */
                   public SQLNonTransientException(Throwable cause) {
                   super(cause);
             }

                   /**
     125        * Constructs a <code>SQLTransientException</code> object
     126        * with a given
     127        * <code>reason</code> and  <code>cause</code>.
     128        * The <code>SQLState</code> is  initialized to <code>null</code>
     129        * and the vendor code is initialized to 0.
     130        * <p>
     131        * @param reason a description of the exception.
     132        * @param cause the underlying reason for this <code>SQLException</code> (which is saved for later retrieval by the <code>getCause()</code> method); may be null indicating
     133        *     the cause is non-existent or unknown.
     134        * @since 1.6
     135        */
                   public SQLNonTransientException(String reason, Throwable cause) {
                   super(reason,cause);

              }

                  /**
     142        * Constructs a <code>SQLNonTransientException</code> object
     143        * with a given
     144        * <code>reason</code>, <code>SQLState</code> and  <code>cause</code>.
     145        * The vendor code is initialized to 0.
     146        * <p>
     147        * @param reason a description of the exception.
     148        * @param SQLState an XOPEN or SQL:2003 code identifying the exception
     149        * @param cause the underlying reason for this <code>SQLException</code> (which is saved for later retrieval by the <code>getCause()</code> method); may be null indicating
     150        *     the cause is non-existent or unknown.
     151        * @since 1.6
     152        */
                  public SQLNonTransientException(String reason, String SQLState, Throwable cause) {
                   super(reason,SQLState,cause);
               }

                  /**
     158        *  Constructs a <code>SQLNonTransientException</code> object
     159        * with a given
     160        * <code>reason</code>, <code>SQLState</code>, <code>vendorCode</code>
     161        * and  <code>cause</code>.
     162        * <p>
     163        * @param reason a description of the exception
     164        * @param SQLState an XOPEN or SQL:2003 code identifying the exception
     165        * @param vendorCode a database vendor-specific exception code
     166        * @param cause the underlying reason for this <code>SQLException</code> (which is saved for later retrieval by the <code>getCause()</code> method); may be null indicating
     167        *     the cause is non-existent or unknown.
     168        * @since 1.6
     169        */
                  public SQLNonTransientException(String reason, String SQLState, int vendorCode, Throwable cause) {
                   super(reason,SQLState,vendorCode,cause);
              }

                  private static final long serialVersionUID = -9104382843534716547L;
       }




