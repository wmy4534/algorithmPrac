#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    char word[100], reverse[100];
    scanf("%s", word);
    
    int length = (int) strlen(word);
    for (int i = 0; i < length; i++) {
        reverse[length - 1 - i] = word[i];
    }

    for (int i = 0; i < length; i++) {
        if (word[i] != reverse[i]) {
            printf("0\n");
            return 0;
        }
    }
    printf("1\n");
    return 0;
}

