#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    float totalCredit = 0, total = 0;
    for (int i = 0; i < 20; i++) {
        float credit = 0;
        char word[50], grade[2] = { 0, };
        float score = 0;
        scanf("%s %f %s", word, &credit, grade);
        bool pass = false;
        switch (grade[0]) {
            case 'A':
                score = 4;
                break;
            case 'B':
                score = 3;
                break;
            case 'C':
                score = 2;
                break;
            case 'D':
                score = 1;
                break;
            case 'F':
                score = 0;
                break;
            default: // pass인 경우
                pass = true;
                break;
        }
        if (grade[1] == '+') {
            score += 0.5;
        }
        
        if (pass)
            continue;
        total += score * credit;
        totalCredit += credit;
    }
    printf("%f\n", total / totalCredit);
    return 0;
}

