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

    int n, m;
    std::cin >> n >> m;

    if (n == 1 || m == 1) {
        std::cout << std::max(n, m);
        return;
	}

    std::cout << (n * 2) + (m * 2) - 4;

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}