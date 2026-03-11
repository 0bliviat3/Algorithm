#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

    int n;
    std::cin >> n;
    n--;
    int prev, now;
	bool flag = 0;
	std::cin >> prev;

    for (int i = 0; i < n; i++) {
        std::cin >> now;

        if (prev == now) {
            std::cout << "NO";
            return;
		}

        if (flag == 0) {
            if (prev > now) {
                flag = 1;
            }
        }
        else {
            if (prev < now) {
                std::cout << "NO";
                return;
            }
        }
        prev = now;
        
    }

    std::cout << "YES";


}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}