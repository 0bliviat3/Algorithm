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

    while (true) {
        int n;
        std::cin >> n;

		if (n == 0) break;

        if (n > 5000000) {
			std::cout << n / 10 * 8 << "\n";
        }
        else if (n > 1000000) {
            std::cout << n / 10 * 9 << "\n";
        }
        else {
			std::cout << n << "\n";
        }
    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}