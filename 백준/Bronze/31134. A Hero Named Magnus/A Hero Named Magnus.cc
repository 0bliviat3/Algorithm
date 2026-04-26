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

    int T;
    std::cin >> T;

    while (T--) {
        long long x;
        std::cin >> x;

        std::cout << 2 * x - 1 << '\n';
    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}