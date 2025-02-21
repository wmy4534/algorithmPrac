#include <stdio.h>

int main(int argc, const char * argv[]) {
    char ms[2], tk[2], rps[3][2] = {{'S', 'R'}, {'R', 'P'}, {'P', 'S'}}; // 민성, 태경
    scanf("%c %c %c %c", &ms[0], &ms[1], &tk[0], &tk[1]);
    
    if (ms[0] == ms[1]) {
        char c = ms[0], win = 'S', lose = 'S';
        for (int i = 0; i < 3; i++) {
            if (rps[i][0] == c) {
                win = rps[i][1];
            }
            if (rps[i][1] == c) {
                lose = rps[i][0];
            }
        }
        int hasWin = 0, hasLose = 0;
        for (int i = 0; i < 2; i++) {
            if (tk[i] == win) {
                hasWin = 1;
            } else if (tk[i] == lose) {
                hasLose = 1;
            }
        }
        if (hasWin) {
            printf("TK\n");
        } else if (hasLose && tk[0] == tk[1]) {
            printf("MS\n");
        } else {
            printf("?\n");
        }
    } else if (tk[0] == tk[1]) {
        char c = tk[0], win = 'S', lose = 'S';
        for (int i = 0; i < 3; i++) {
            if (rps[i][0] == c) {
                win = rps[i][1];
            }
            if (rps[i][1] == c) {
                lose = rps[i][0];
            }
        }
        int hasWin = 0, hasLose = 0;
        for (int i = 0; i < 2; i++) {
            if (ms[i] == win) {
                hasWin = 1;
            } else if (ms[i] == lose) {
                hasLose = 1;
            }
        }
        if (hasWin) {
            printf("MS\n");
        } else {
            printf("?\n");
        }
    } else {
        printf("?\n");
    }
    
    return 0;
}

