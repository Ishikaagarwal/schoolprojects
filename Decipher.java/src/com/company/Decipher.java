package com.company;

/**
 *  Decipher.java
 *  Decipher prompts the user for 4 inputs:
 *  (1) A key code, which is an english word, phrase, or sentence.
 *  (2) The name of the text file to be opened and then encrypted or decrypted.
 *  (3) The name of the text file to be created.
 *  (4) A String of "1" or "2" to indicate a choice of encryption or decryption.
 *  The program employs the concept of a substitution cipher with a key, so that
 *  if the user enters the phrase "Monta Vista" as the key code, a substitution
 *  will be made using the following scheme:
 *  fullKey:  MONTAVISBCDEFGHJKLPQRUWXYZ
 *  alphabet: ABCDEFGHIJKLMNOPQRSTUVWXYZ
 *  The user will choose whether to go from fullKey to alphabet (encrypt), or
 *  from alphabet to fullKey (decrypt).  The result is always printed to the
 *  terminal window, and saved in the text file chosen by the user.
 *  @author Ishika Agarwal
 *  @version 1.0
 *  @since 9/20/2016
 */


class Decipher {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String userKey;
    /**
     * The full key, created from the user's key word, phrase, or sentence.
     */
    private String fullKey;


    /**
     * Creates a Decipher object.  The 4 String fields are initialized her.
     * These Strings will be changed with user input.
     */
    Decipher(String userKey) {
        this.userKey = userKey.toUpperCase();
        fullKey = makeKey();
    }

    /**
     * This method will find the key by finding all the non repeated
     * letters in
     * fullKey. Then taking those letters, it will replace values in the
     * alphabet
     * so that they are no repeated letters in the key.
     *
     * @return The String key that will be used to encrypt
     */
    private String makeKey() {
        String nonRepeatedLetters = "";
        String fullKeyCopy = userKey;

        for (int i = 0; i < userKey.length(); i++) {
            if (nonRepeatedLetters.indexOf(fullKeyCopy.charAt(i)) == -1) {
                nonRepeatedLetters += fullKeyCopy.substring(i, i + 1);
            }
        }

        String key = nonRepeatedLetters;
        for (int i = 0; i < alphabet.length(); i++) {
            if (key.indexOf(alphabet.charAt(i)) == -1) {
                key += alphabet.substring(i, i + 1);
            }
        }

        return key;
    }

    /**
     * Will encrypt the input by taking one letter of txtInput at a time and checking to see
     * where it is in the alphabet, and then take that position and see where it is in
     * the fullKey so that it can add that character to the encrypted value
     * @param txtInput      the input from the input text file
     * @return              String value of the encrypted text
     */
    String encrypt(String txtInput) {
        String encrypted = "";
        txtInput = txtInput.toUpperCase();

        for (int i = 0; i < txtInput.length(); i++) {
            char txtChar = txtInput.charAt(i);
            if (isLetter(txtChar)) {
                int txtCharIndex = alphabet.indexOf(txtChar);
                encrypted += fullKey.charAt(txtCharIndex);
            } else {
                encrypted += txtInput.substring(i, i + 1);
            }
        }
        return encrypted;
    }

    /**
     * Will encrypt the input by taking one letter of txtInput at a time and checking to see
     * where it is in the key, and then take that position and see where it is in
     * the alphabet so that it can add that character to the decrypted value
     * @param txtInput      the input from the input text file
     * @return              String value of the decrypted text
     */
    String decrypt(String txtInput) {
        String decrypted = "";
        txtInput = txtInput.toUpperCase();

        for (int i = 0; i < txtInput.length(); i++) {
            char txtChar = txtInput.charAt(i);
            if (isLetter(txtChar)) {
                int txtCharIndex = fullKey.indexOf(txtChar);
                decrypted += alphabet.charAt(txtCharIndex);
            } else {
                decrypted += txtInput.substring(i, i + 1);
            }
        }
        return decrypted;
    }

    /**
     * Will check to see if the character passed is a letter from A to Z
     * @param compare         character that will be compared
     * @return                boolean value of whether or not the character is a letter
     */
    private boolean isLetter(char compare) {
        return compare >= 'A' && compare <= 'Z';
    }
}