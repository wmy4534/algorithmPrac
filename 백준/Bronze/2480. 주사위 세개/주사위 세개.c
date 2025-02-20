#include <stdio.h>

int main(int argc, const char * argv[]) {
    int num[3], result;
    for (int i = 0; i < 3; i++) {
        scanf("%d", &num[i]);
    }
    if (num[0] != num[1] && num[1] != num[2] && num[0] != num[2]) {
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (max < num[i]) {
                max = num[i];
            }
        }
        result = max * 100;
    } else if (num[0] == num[1] && num[1] == num[2]) {
        result = 10000 + (num[0] * 1000);
    } else {
        result = 1000;
        if (num[0] == num[1]) {
            result += 100 * num[0];
        } else if (num[1] == num[2]) {
            result += 100 * num[1];
        } else {
            result += 100 * num[2];
        }
    }
    printf("%d", result);
    return 0;
}
