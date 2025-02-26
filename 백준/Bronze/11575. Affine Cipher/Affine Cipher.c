#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    int T, a, b;
    char word[1000000];
    scanf("%d", &T);
    for (int t = 0; t < T; t++) {
        scanf("%d %d", &a, &b);
        scanf("%s", word);
        int len = (int) strlen(word);
        for (int i = 0; i < len; i++) {
            int c = word[i] - 'A';
            c = (a * c + b) % 26;
            printf("%c", c + 'A');
        }
        printf("\n");
    }
}
