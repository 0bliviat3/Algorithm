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

    int arr[3];
    for (int i = 0; i < 3; i++) {
        std::cin >> arr[i];
	}

	std::sort(arr, arr + 3);

    std::string order;
	std::cin >> order;

    for (char c : order) {
		std::cout << arr[c - 'A'] << " ";
    }
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}