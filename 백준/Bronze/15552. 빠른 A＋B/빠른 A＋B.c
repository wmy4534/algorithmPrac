#include <stdio.h>

int main(int argc, const char * argv[]) {
    int T = 0, A, B; // 테스트케이스의 수
    scanf("%d", &T);
    
    for (int t = 0; t < T; t++) {
        scanf("%d %d", &A, &B);
        printf("%d\n", A + B);
    }
    
    return 0;
}
