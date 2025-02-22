#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    char word[1000000], c;
    int cnt[26] = { 0, }, len = 0, idx = 0;
    scanf("%s", word);
    len = (int)strlen(word);
    for (int i = 0; i < len; i++) {
        c = word[i];
        if (c < 'a') {
            idx = c - 'A';
        } else {
            idx = c - 'a';
        }
        cnt[idx]++;
    }
    int mostIdx = 0, maxCnt = 0;
    bool isDuplicate = false;
    for (int i = 0; i < 26; i++) {
        if (maxCnt < cnt[i]) {
            maxCnt = cnt[i];
            mostIdx = i;
            isDuplicate = false;
        } else if (maxCnt == cnt[i]) {
            isDuplicate = true;
        }
    }
    if (isDuplicate) {
        printf("?\n");
    } else {
        printf("%c", mostIdx + 'A');
    }
    
    return 0;
}

