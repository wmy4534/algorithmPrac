#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    char num[100000] = "1";
    while (true) {
        scanf("%s", num);
        if (!strcmp(num, "0")) {
            break;
        }
        int len = (int) strlen(num);
        bool isPal = true;
        for (int i = 0; i < len/2; i++) {
            if (num[i] != num[len - i - 1]) {
                isPal = false;
            }
        }
        if (isPal) {
            printf("yes\n");
        } else {
            printf("no\n");
        }
    }
    return 0;
}
