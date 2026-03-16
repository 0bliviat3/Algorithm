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

    std::vector<int> arr(n + 1, 0);
	
    while (m--) {
        int a, b;
		std::cin >> a >> b;
		arr[a]++;
		arr[b]++;
    }

    for (int i = 1; i <= n; i++) {
        std::cout << arr[i] << "\n";
    }
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}