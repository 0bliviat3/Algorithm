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
	std::cin.ignore();

    for (int i = 1; i <= n; i++) {
        std::string line;
		std::getline(std::cin, line);

        if (line == "1 2 3 4 5 1 2 3 4 5") {
            std::cout << i << "\n";
        }
    }
    
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}