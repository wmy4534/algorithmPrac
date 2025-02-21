#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    int N = 0, cnt = 0;
    scanf("%d", &N);
    char word[100];
    for (int i = 0; i < N; i++) {
        scanf("%s", word);
        int length = (int) strlen(word);
        bool arr[26] = { false, };
        char before = 'a';
        bool isGroup = true;
        for (int l = 0; l < length; l++) {
            char c = word[l];
            if (before == c) { // 연속된 알파벳
                arr[c - 'a'] = true;
            } else { // 다른 단어
                if (arr[c - 'a']) { // 이미 등장한 알파벳이라면
                    isGroup = false;
                } else { // 처음 등장하는 알파벳이라면
                    arr[c - 'a'] = true;
                    before = c;
                }
            }
        }
        if (isGroup) {
            cnt++;
        }
    }
    printf("%d", cnt);
    
    return 0;
}

